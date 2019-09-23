package com.linkedin.project.rest.resources;

import com.linkedin.common.urn.ProjectUrn;
import com.linkedin.metadata.aspect.ProjectAspect;
import com.linkedin.metadata.dao.BaseLocalDAO;
import com.linkedin.metadata.restli.BaseSnapshotResource;
import com.linkedin.metadata.snapshot.ProjectSnapshot;
import com.linkedin.metadata.snapshot.SnapshotKey;
import com.linkedin.parseq.Task;
import com.linkedin.project.ProjectKey;
import com.linkedin.restli.common.ComplexResourceKey;
import com.linkedin.restli.common.EmptyRecord;
import com.linkedin.restli.common.validation.CreateOnly;
import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.PathKeys;
import com.linkedin.restli.server.annotations.PathKeysParam;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.annotations.RestMethod;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Named;


/**
 * Rest.li entry point: /projects/{projectKey}/snapshot
 */
@Slf4j
@RestLiCollection(name = "snapshot", namespace = "com.linkedin.project", parent = Projects.class)
@CreateOnly({"urn"})
public class ProjectsSnapshot extends BaseSnapshotResource<ProjectUrn, ProjectSnapshot, ProjectAspect> {

    private static final String PROJECT_KEY = Projects.class.getAnnotation(RestLiCollection.class).keyName();

    public ProjectsSnapshot() {
        super(ProjectSnapshot.class, ProjectAspect.class);
    }

    @Inject
    @Named("projectDao")
    private BaseLocalDAO localDAO;

    @Override
    @RestMethod.Create
    public Task<CreateResponse> create(@Nonnull ProjectSnapshot projectSnapshot) {
        return super.create(projectSnapshot);
    }

    @Override
    @RestMethod.Get
    public Task<ProjectSnapshot> get(@Nonnull ComplexResourceKey<SnapshotKey, EmptyRecord> snapshotKey) {
        return super.get(snapshotKey);
    }

    @Nonnull
    @Override
    protected BaseLocalDAO<ProjectAspect, ProjectUrn> getLocalDAO() {
        return localDAO;
    }

    @Nonnull
    @Override
    protected ProjectUrn getUrn(@PathKeysParam @Nonnull PathKeys keys) {
        return new ProjectUrn(keys.<ComplexResourceKey<ProjectKey, EmptyRecord>>get(PROJECT_KEY).getKey().getName());
    }
}