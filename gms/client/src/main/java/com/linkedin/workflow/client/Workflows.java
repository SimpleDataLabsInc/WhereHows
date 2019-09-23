package com.linkedin.workflow.client;

import com.linkedin.common.client.WorkflowsClient;
import com.linkedin.common.urn.WorkflowUrn;
import com.linkedin.metadata.snapshot.WorkflowSnapshot;
import com.linkedin.workflow.*;
import com.linkedin.metadata.snapshot.SnapshotKey;
import com.linkedin.r2.RemoteInvocationException;
import com.linkedin.restli.client.*;
import com.linkedin.restli.common.ComplexResourceKey;
import com.linkedin.restli.common.EmptyRecord;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Workflows extends WorkflowsClient {

    private static final WorkflowsRequestBuilders WORKFLOWS_REQUEST_BUILDERS = new WorkflowsRequestBuilders();
    private static final InfoRequestBuilders INFO_REQUEST_BUILDERS = new InfoRequestBuilders();
    private static final SnapshotRequestBuilders SNAPSHOT_REQUEST_BUILDERS = new SnapshotRequestBuilders();

    public Workflows(@Nonnull Client restliClient) {
        super(restliClient);
    }

    @Nonnull
    public Workflow get(@Nonnull WorkflowUrn urn)
            throws RemoteInvocationException {
        GetRequest<Workflow> getRequest = WORKFLOWS_REQUEST_BUILDERS.get()
                .id(new ComplexResourceKey<>(toWorkflowKey(urn), new EmptyRecord()))
                .build();

        return _client.sendRequest(getRequest).getResponse().getEntity();
    }

//    @Nonnull
//    public List<CorpGroup> getAll()
//            throws RemoteInvocationException {
//        GetAllRequest<CorpGroup> getAllRequest = CORP_GROUPS_REQUEST_BUILDERS.getAll()
//                .build();
//        return _client.sendRequest(getAllRequest).getResponseEntity().getElements();
//    }

    @Nonnull
    public Map<WorkflowUrn, Workflow> batchGet(@Nonnull Set<WorkflowUrn> urns)
            throws RemoteInvocationException {
        BatchGetEntityRequest<ComplexResourceKey<WorkflowKey, EmptyRecord>, Workflow> batchGetRequest
                = WORKFLOWS_REQUEST_BUILDERS.batchGet()
                .ids(urns.stream().map(this::getKeyFromUrn).collect(Collectors.toSet()))
                .build();

        return _client.sendRequest(batchGetRequest).getResponseEntity().getResults()
                .entrySet().stream().collect(Collectors.toMap(
                        entry -> getUrnFromKey(entry.getKey()),
                        entry -> entry.getValue().getEntity())
                );
    }

    @Nonnull
    public SnapshotKey create(@Nonnull WorkflowUrn urn, @Nonnull WorkflowSnapshot snapshot)
            throws RemoteInvocationException {
        CreateIdRequest<ComplexResourceKey<SnapshotKey, EmptyRecord>, WorkflowSnapshot> createRequest =
                SNAPSHOT_REQUEST_BUILDERS.create()
                        .workflowKey(getKeyFromUrn(urn))
                        .input(snapshot)
                        .build();

        return _client.sendRequest(createRequest).getResponseEntity().getId().getKey();
    }

    public void createInfo(@Nonnull WorkflowUrn workflowUrn,
                           @Nonnull WorkflowInfo workflowInfo) throws RemoteInvocationException {
        CreateIdRequest<Long, WorkflowInfo> request = INFO_REQUEST_BUILDERS.create()
                .workflowKey(getKeyFromUrn(workflowUrn))
                .input(workflowInfo)
                .build();
        _client.sendRequest(request).getResponse();
    }

    @Nonnull
    private ComplexResourceKey<WorkflowKey, EmptyRecord> getKeyFromUrn(@Nonnull WorkflowUrn urn) {
        return new ComplexResourceKey<>(toWorkflowKey(urn), new EmptyRecord());
    }

    @Nonnull
    private WorkflowUrn getUrnFromKey(@Nonnull ComplexResourceKey<WorkflowKey, EmptyRecord> key) {
        return toWorkflowUrn(key.getKey());
    }
}