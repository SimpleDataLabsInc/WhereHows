package com.linkedin.common.client;

import com.linkedin.common.urn.CorpGroupUrn;
import com.linkedin.identity.CorpGroupKey;
import com.linkedin.restli.client.Client;

import javax.annotation.Nonnull;

public class CorpGroupsClient extends BaseClient {

    protected CorpGroupsClient(@Nonnull Client restliClient) {
        super(restliClient);
    }

    @Nonnull
    protected CorpGroupKey toCorpGroupKey(@Nonnull CorpGroupUrn urn) {
        return new CorpGroupKey().setName(urn.getGroupNameEntity());
    }

    @Nonnull
    protected CorpGroupUrn toCorpGroupUrn(@Nonnull CorpGroupKey key) {
        return new CorpGroupUrn(key.getName());
    }
}
