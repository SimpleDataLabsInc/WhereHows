package com.linkedin.identity.client;

import com.linkedin.common.client.CorpGroupsClient;
import com.linkedin.common.urn.CorpGroupUrn;
import com.linkedin.identity.CorpGroup;
import com.linkedin.identity.CorpGroupInfo;
import com.linkedin.identity.CorpGroupKey;
import com.linkedin.identity.CorpGroupsRequestBuilders;
import com.linkedin.identity.corpgroup.InfoRequestBuilders;
import com.linkedin.identity.corpgroup.SnapshotRequestBuilders;
import com.linkedin.metadata.snapshot.CorpGroupSnapshot;
import com.linkedin.metadata.snapshot.SnapshotKey;
import com.linkedin.r2.RemoteInvocationException;
import com.linkedin.restli.client.*;
import com.linkedin.restli.common.ComplexResourceKey;
import com.linkedin.restli.common.EmptyRecord;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CorpGroups extends CorpGroupsClient {

    private static final CorpGroupsRequestBuilders CORP_GROUPS_REQUEST_BUILDERS = new CorpGroupsRequestBuilders();
    private static final InfoRequestBuilders INFO_REQUEST_BUILDERS = new InfoRequestBuilders();
    private static final SnapshotRequestBuilders SNAPSHOT_REQUEST_BUILDERS = new SnapshotRequestBuilders();

    public CorpGroups(@Nonnull Client restliClient) {
        super(restliClient);
    }

    @Nonnull
    public CorpGroup get(@Nonnull CorpGroupUrn urn)
            throws RemoteInvocationException {
        GetRequest<CorpGroup> getRequest = CORP_GROUPS_REQUEST_BUILDERS.get()
                .id(new ComplexResourceKey<>(toCorpGroupKey(urn), new EmptyRecord()))
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
    public Map<CorpGroupUrn, CorpGroup> batchGet(@Nonnull Set<CorpGroupUrn> urns)
            throws RemoteInvocationException {
        BatchGetEntityRequest<ComplexResourceKey<CorpGroupKey, EmptyRecord>, CorpGroup> batchGetRequest
                = CORP_GROUPS_REQUEST_BUILDERS.batchGet()
                .ids(urns.stream().map(this::getKeyFromUrn).collect(Collectors.toSet()))
                .build();

        return _client.sendRequest(batchGetRequest).getResponseEntity().getResults()
                .entrySet().stream().collect(Collectors.toMap(
                        entry -> getUrnFromKey(entry.getKey()),
                        entry -> entry.getValue().getEntity())
                );
    }

    @Nonnull
    public SnapshotKey create(@Nonnull CorpGroupUrn urn, @Nonnull CorpGroupSnapshot snapshot)
            throws RemoteInvocationException {
        CreateIdRequest<ComplexResourceKey<SnapshotKey, EmptyRecord>, CorpGroupSnapshot> createRequest =
                SNAPSHOT_REQUEST_BUILDERS.create()
                        .corpGroupKey(getKeyFromUrn(urn))
                        .input(snapshot)
                        .build();

        return _client.sendRequest(createRequest).getResponseEntity().getId().getKey();
    }

    public void createInfo(@Nonnull CorpGroupUrn corpGroupUrn,
                                   @Nonnull CorpGroupInfo corpGroupInfo) throws RemoteInvocationException {
        CreateIdRequest<Long, CorpGroupInfo> request = INFO_REQUEST_BUILDERS.create()
                .corpGroupKey(getKeyFromUrn(corpGroupUrn))
                .input(corpGroupInfo)
                .build();
        _client.sendRequest(request).getResponse();
    }

    @Nonnull
    private ComplexResourceKey<CorpGroupKey, EmptyRecord> getKeyFromUrn(@Nonnull CorpGroupUrn urn) {
        return new ComplexResourceKey<>(toCorpGroupKey(urn), new EmptyRecord());
    }

    @Nonnull
    private CorpGroupUrn getUrnFromKey(@Nonnull ComplexResourceKey<CorpGroupKey, EmptyRecord> key) {
        return toCorpGroupUrn(key.getKey());
    }
}