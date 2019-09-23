package com.linkedin.workflow.rest.resources;

import com.linkedin.parseq.Task;
import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.annotations.Optional;
import com.linkedin.restli.server.annotations.QueryParam;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.annotations.RestMethod;
import com.linkedin.workflow.WorkflowInfo;

import javax.annotation.Nonnull;


/**
 * Rest.li entry point: /workflows/{workflowKey}/info
 */
@RestLiCollection(name = "info", namespace = "com.linkedin.workflow", parent = Workflows.class)
public final class WorkflowsInfoResource extends BaseWorkflowsAspectResource<WorkflowInfo> {

    public WorkflowsInfoResource() {
        super(WorkflowInfo.class);
    }

    @Nonnull
    @Override
    @RestMethod.Create
    public Task<CreateResponse> create(@Nonnull WorkflowInfo workflowInfo) {
        return super.create(workflowInfo);
    }

    @Nonnull
    @Override
    @RestMethod.Get
    public Task<WorkflowInfo> get(@QueryParam("version") @Optional("0") @Nonnull Long version) {
        return super.get(version);
    }
}