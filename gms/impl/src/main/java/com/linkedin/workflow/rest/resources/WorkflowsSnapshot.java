package com.linkedin.workflow.rest.resources;

import com.linkedin.common.urn.WorkflowUrn;
import com.linkedin.metadata.aspect.WorkflowAspect;
import com.linkedin.metadata.dao.BaseLocalDAO;
import com.linkedin.metadata.restli.BaseSnapshotResource;
import com.linkedin.metadata.snapshot.SnapshotKey;
import com.linkedin.metadata.snapshot.WorkflowSnapshot;
import com.linkedin.parseq.Task;
import com.linkedin.restli.common.ComplexResourceKey;
import com.linkedin.restli.common.EmptyRecord;
import com.linkedin.restli.common.validation.CreateOnly;
import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.PathKeys;
import com.linkedin.restli.server.annotations.PathKeysParam;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.annotations.RestMethod;
import com.linkedin.workflow.WorkflowKey;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Named;


/**
 * Rest.li entry point: /workflows/{workflowKey}/snapshot
 */
@Slf4j
@RestLiCollection(name = "snapshot", namespace = "com.linkedin.project", parent = Workflows.class)
@CreateOnly({"urn"})
public class WorkflowsSnapshot extends BaseSnapshotResource<WorkflowUrn, WorkflowSnapshot, WorkflowAspect> {

    private static final String WORKFLOW_KEY = Workflows.class.getAnnotation(RestLiCollection.class).keyName();

    public WorkflowsSnapshot() {
        super(WorkflowSnapshot.class, WorkflowAspect.class);
    }

    @Inject
    @Named("workflowDao")
    private BaseLocalDAO localDAO;

    @Override
    @RestMethod.Create
    public Task<CreateResponse> create(@Nonnull WorkflowSnapshot workflowSnapshot) {
        return super.create(workflowSnapshot);
    }

    @Override
    @RestMethod.Get
    public Task<WorkflowSnapshot> get(@Nonnull ComplexResourceKey<SnapshotKey, EmptyRecord> snapshotKey) {
        return super.get(snapshotKey);
    }

    @Nonnull
    @Override
    protected BaseLocalDAO<WorkflowAspect, WorkflowUrn> getLocalDAO() {
        return localDAO;
    }

    @Nonnull
    @Override
    protected WorkflowUrn getUrn(@PathKeysParam @Nonnull PathKeys keys) {
        return new WorkflowUrn(keys.<ComplexResourceKey<WorkflowKey, EmptyRecord>>get(WORKFLOW_KEY).getKey().getName());
    }
}