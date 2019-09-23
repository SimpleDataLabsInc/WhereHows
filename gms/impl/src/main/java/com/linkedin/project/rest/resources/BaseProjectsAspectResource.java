package com.linkedin.project.rest.resources;

import com.linkedin.common.urn.ProjectUrn;
import com.linkedin.data.template.RecordTemplate;
import com.linkedin.metadata.aspect.ProjectAspect;
import com.linkedin.metadata.dao.BaseLocalDAO;
import com.linkedin.metadata.restli.BaseVersionedAspectResource;
import com.linkedin.project.ProjectKey;
import com.linkedin.restli.common.ComplexResourceKey;
import com.linkedin.restli.common.EmptyRecord;
import com.linkedin.restli.server.PathKeys;
import com.linkedin.restli.server.annotations.PathKeysParam;
import com.linkedin.restli.server.annotations.RestLiCollection;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Named;


public class BaseProjectsAspectResource<ASPECT extends RecordTemplate>
        extends BaseVersionedAspectResource<ProjectUrn, ProjectAspect, ASPECT> {

    private static final String PROJECT_KEY = Projects.class.getAnnotation(RestLiCollection.class).keyName();

    public BaseProjectsAspectResource(Class<ASPECT> aspectClass) {
        super(ProjectAspect.class, aspectClass);
    }

    @Inject
    @Named("projectDao")
    private BaseLocalDAO localDAO;

    @Nonnull
    @Override
    protected BaseLocalDAO getLocalDAO() {
        return localDAO;
    }

    @Nonnull
    @Override
    protected ProjectUrn getUrn(@PathKeysParam @Nonnull PathKeys keys) {
        return new ProjectUrn(keys.<ComplexResourceKey<ProjectKey, EmptyRecord>>get(PROJECT_KEY).getKey().getName());
    }
}