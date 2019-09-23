package com.linkedin.project.rest.resources;

import com.linkedin.common.Configurations;
import com.linkedin.common.urn.ProjectUrn;
import com.linkedin.metadata.aspect.ProjectAspect;
import com.linkedin.metadata.dao.BaseLocalDAO;
import com.linkedin.metadata.dao.utils.ModelUtils;
import com.linkedin.metadata.restli.BaseEntityResource;
import com.linkedin.metadata.snapshot.ProjectSnapshot;
import com.linkedin.parseq.Task;
import com.linkedin.project.Project;
import com.linkedin.project.ProjectInfo;
import com.linkedin.project.ProjectKey;
import com.linkedin.restli.common.ComplexResourceKey;
import com.linkedin.restli.common.EmptyRecord;
import com.linkedin.restli.server.annotations.*;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.linkedin.metadata.restli.RestliConstants.*;

@RestLiCollection(name = "projects", namespace = "com.linkedin.project", keyName = "project")
public final class Projects extends BaseEntityResource<
        // @formatter:off
        ProjectKey,
        Project,
        ProjectUrn,
        ProjectSnapshot,
        ProjectAspect> {
    // @formatter:on

    @Inject
    @Named("projectDao")
    private BaseLocalDAO _localDAO;

    public Projects() {
        super(ProjectSnapshot.class, ProjectAspect.class);
    }

    @Override
    @Nonnull
    protected BaseLocalDAO getLocalDAO() {
        return _localDAO;
    }

    @Override
    @Nonnull
    protected ProjectUrn toUrn(@Nonnull ProjectKey key) {
        return new ProjectUrn(key.getName());
    }

    @Override
    @Nonnull
    protected ProjectKey toKey(@Nonnull ProjectUrn urn) {
        return new ProjectKey().setName(urn.getNameEntity());
    }

    @Override
    @Nonnull
    protected Project toValue(@Nonnull ProjectSnapshot snapshot) {
        final Project value = new Project().setName(snapshot.getUrn().getNameEntity());
        ModelUtils.getAspectsFromSnapshot(snapshot).forEach(aspect -> {
            if (aspect instanceof ProjectInfo) {
                value.setInfo(ProjectInfo.class.cast(aspect));
            }
        });
        return value;
    }

//    @RestMethod.GetAll
//    @Nonnull
//    public Task<List<Project>> getAll(@QueryParam(PARAM_ASPECTS) @Optional("[]") @Nonnull String[] aspectNames,
//                                       @QueryParam(PARAM_FILTER) @Optional @Nullable Filter filter) {
//        return super.getAll(aspectNames, filter);
//    }

    @Override
    @Nonnull
    protected ProjectSnapshot toSnapshot(@Nonnull Project project, @Nonnull ProjectUrn projectUrn) {
        final List<ProjectAspect> aspects = new ArrayList<>();
        if (project.hasInfo()) {
            aspects.add(ModelUtils.newAspectUnion(ProjectAspect.class, project.getInfo()));
        }
        return ModelUtils.newSnapshot(ProjectSnapshot.class, projectUrn, aspects);
    }

    @RestMethod.Get
    @Override
    @Nonnull
    public Task<Project> get(@Nonnull ComplexResourceKey<ProjectKey, EmptyRecord> key,
                              @QueryParam(PARAM_ASPECTS) @Optional("[]") String[] aspectNames) {
        return super.get(key, aspectNames);
    }

    @RestMethod.BatchGet
    @Override
    @Nonnull
    public Task<Map<ComplexResourceKey<ProjectKey, EmptyRecord>, Project>> batchGet(
            @Nonnull Set<ComplexResourceKey<ProjectKey, EmptyRecord>> keys,
            @QueryParam(PARAM_ASPECTS) @Optional("[]") String[] aspectNames) {
        return super.batchGet(keys, aspectNames);
    }

//    @Finder(FINDER_SEARCH)
//    @Override
//    @Nonnull
//    public Task<CollectionResult<Project, SearchResultMetadata>> search(@QueryParam(PARAM_INPUT) @Nonnull String input,
//                                                                         @QueryParam(PARAM_ASPECTS) @Optional("[]") @Nonnull String[] aspectNames,
//                                                                         @QueryParam(PARAM_FILTER) @Optional @Nullable Filter filter,
//                                                                         @PagingContextParam @Nonnull PagingContext pagingContext) {
//        return super.search(input, aspectNames, filter, pagingContext);
//    }
}