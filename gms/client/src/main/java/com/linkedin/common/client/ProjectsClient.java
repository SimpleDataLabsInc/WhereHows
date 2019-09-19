package com.linkedin.common.client;

import com.linkedin.common.urn.ProjectUrn;
import com.linkedin.project.ProjectKey;
import com.linkedin.restli.client.Client;

import javax.annotation.Nonnull;

public class ProjectsClient extends BaseClient {

    protected ProjectsClient(@Nonnull Client restliClient) {
        super(restliClient);
    }

    @Nonnull
    protected ProjectKey toProjectKey(@Nonnull ProjectUrn urn) {
        return new ProjectKey().setName(urn.getNameEntity());
    }

    @Nonnull
    protected ProjectUrn toProjectUrn(@Nonnull ProjectKey key) {
        return new ProjectUrn(key.getName());
    }
}
