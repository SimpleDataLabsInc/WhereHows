package com.linkedin.project.rest.resources;

import com.linkedin.parseq.Task;
import com.linkedin.project.ProjectInfo;
import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.annotations.Optional;
import com.linkedin.restli.server.annotations.QueryParam;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.annotations.RestMethod;
import javax.annotation.Nonnull;


/**
 * Rest.li entry point: /projects/{projectKey}/info
 */
@RestLiCollection(name = "info", namespace = "com.linkedin.project", parent = Projects.class)
public final class ProjectsInfoResource extends BaseProjectsAspectResource<ProjectInfo> {

    public ProjectsInfoResource() {
        super(ProjectInfo.class);
    }

    @Nonnull
    @Override
    @RestMethod.Create
    public Task<CreateResponse> create(@Nonnull ProjectInfo projectInfo) {
        return super.create(projectInfo);
    }

    @Nonnull
    @Override
    @RestMethod.Get
    public Task<ProjectInfo> get(@QueryParam("version") @Optional("0") @Nonnull Long version) {
        return super.get(version);
    }
}