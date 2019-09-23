package com.linkedin.workflow.rest.resources;

import com.linkedin.common.urn.WorkflowUrn;
import com.linkedin.data.template.RecordTemplate;
import com.linkedin.metadata.aspect.WorkflowAspect;
import com.linkedin.metadata.dao.BaseLocalDAO;
import com.linkedin.metadata.restli.BaseVersionedAspectResource;
import com.linkedin.restli.common.ComplexResourceKey;
import com.linkedin.restli.common.EmptyRecord;
import com.linkedin.restli.server.PathKeys;
import com.linkedin.restli.server.annotations.PathKeysParam;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.workflow.WorkflowKey;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Named;


public class BaseWorkflowsAspectResource<ASPECT extends RecordTemplate>
        extends BaseVersionedAspectResource<WorkflowUrn, WorkflowAspect, ASPECT> {

    private static final String WORKFLOW_KEY = Workflows.class.getAnnotation(RestLiCollection.class).keyName();

    public BaseWorkflowsAspectResource(Class<ASPECT> aspectClass) {
        super(WorkflowAspect.class, aspectClass);
    }

    @Inject
    @Named("WorkflowDao")
    private BaseLocalDAO localDAO;

    @Nonnull
    @Override
    protected BaseLocalDAO getLocalDAO() {
        return localDAO;
    }

    @Nonnull
    @Override
    protected WorkflowUrn getUrn(@PathKeysParam @Nonnull PathKeys keys) {
        return new WorkflowUrn(keys.<ComplexResourceKey<WorkflowKey, EmptyRecord>>get(WORKFLOW_KEY).getKey().getName());
    }
}