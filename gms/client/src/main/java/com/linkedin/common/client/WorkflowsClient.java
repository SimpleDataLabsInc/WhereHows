package com.linkedin.common.client;

import com.linkedin.common.urn.WorkflowUrn;
import com.linkedin.workflow.WorkflowKey;
import com.linkedin.restli.client.Client;

import javax.annotation.Nonnull;

public class WorkflowsClient extends BaseClient {

    protected WorkflowsClient(@Nonnull Client restliClient) {
        super(restliClient);
    }

    @Nonnull
    protected WorkflowKey toWorkflowKey(@Nonnull WorkflowUrn urn) {
        return new WorkflowKey().setName(urn.getNameEntity());
    }

    @Nonnull
    protected WorkflowUrn toWorkflowUrn(@Nonnull WorkflowKey key) {
        return new WorkflowUrn(key.getName());
    }
}
