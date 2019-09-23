package com.linkedin.project.client;

import com.linkedin.common.client.ProjectsClient;
import com.linkedin.common.urn.ProjectUrn;
import com.linkedin.metadata.snapshot.ProjectSnapshot;
import com.linkedin.project.*;
import com.linkedin.metadata.snapshot.SnapshotKey;
import com.linkedin.r2.RemoteInvocationException;
import com.linkedin.restli.client.*;
import com.linkedin.restli.common.ComplexResourceKey;
import com.linkedin.restli.common.EmptyRecord;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Projects extends ProjectsClient {

    private static final ProjectsRequestBuilders PROJECTS_REQUEST_BUILDERS = new ProjectsRequestBuilders();
    private static final InfoRequestBuilders INFO_REQUEST_BUILDERS = new InfoRequestBuilders();
    private static final SnapshotRequestBuilders SNAPSHOT_REQUEST_BUILDERS = new SnapshotRequestBuilders();

    public Projects(@Nonnull Client restliClient) {
        super(restliClient);
    }

    @Nonnull
    public Project get(@Nonnull ProjectUrn urn)
            throws RemoteInvocationException {
        GetRequest<Project> getRequest = PROJECTS_REQUEST_BUILDERS.get()
                .id(new ComplexResourceKey<>(toProjectKey(urn), new EmptyRecord()))
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
    public Map<ProjectUrn, Project> batchGet(@Nonnull Set<ProjectUrn> urns)
            throws RemoteInvocationException {
        BatchGetEntityRequest<ComplexResourceKey<ProjectKey, EmptyRecord>, Project> batchGetRequest
                = PROJECTS_REQUEST_BUILDERS.batchGet()
                .ids(urns.stream().map(this::getKeyFromUrn).collect(Collectors.toSet()))
                .build();

        return _client.sendRequest(batchGetRequest).getResponseEntity().getResults()
                .entrySet().stream().collect(Collectors.toMap(
                        entry -> getUrnFromKey(entry.getKey()),
                        entry -> entry.getValue().getEntity())
                );
    }

    @Nonnull
    public SnapshotKey create(@Nonnull ProjectUrn urn, @Nonnull ProjectSnapshot snapshot)
            throws RemoteInvocationException {
        CreateIdRequest<ComplexResourceKey<SnapshotKey, EmptyRecord>, ProjectSnapshot> createRequest =
                SNAPSHOT_REQUEST_BUILDERS.create()
                        .projectKey(getKeyFromUrn(urn))
                        .input(snapshot)
                        .build();

        return _client.sendRequest(createRequest).getResponseEntity().getId().getKey();
    }

    public void createInfo(@Nonnull ProjectUrn projectUrn,
                           @Nonnull ProjectInfo projectInfo) throws RemoteInvocationException {
        CreateIdRequest<Long, ProjectInfo> request = INFO_REQUEST_BUILDERS.create()
                .projectKey(getKeyFromUrn(projectUrn))
                .input(projectInfo)
                .build();
        _client.sendRequest(request).getResponse();
    }

    @Nonnull
    private ComplexResourceKey<ProjectKey, EmptyRecord> getKeyFromUrn(@Nonnull ProjectUrn urn) {
        return new ComplexResourceKey<>(toProjectKey(urn), new EmptyRecord());
    }

    @Nonnull
    private ProjectUrn getUrnFromKey(@Nonnull ComplexResourceKey<ProjectKey, EmptyRecord> key) {
        return toProjectUrn(key.getKey());
    }
}