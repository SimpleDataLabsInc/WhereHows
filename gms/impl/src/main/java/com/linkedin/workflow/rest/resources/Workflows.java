package com.linkedin.workflow.rest.resources;

import com.linkedin.common.Configurations;
import com.linkedin.common.urn.ProjectUrn;
import com.linkedin.common.urn.WorkflowUrn;
import com.linkedin.metadata.aspect.ProjectAspect;
import com.linkedin.metadata.aspect.WorkflowAspect;
import com.linkedin.metadata.dao.BaseLocalDAO;
import com.linkedin.metadata.dao.utils.ModelUtils;
import com.linkedin.metadata.restli.BaseEntityResource;
import com.linkedin.metadata.snapshot.ProjectSnapshot;
import com.linkedin.metadata.snapshot.WorkflowSnapshot;
import com.linkedin.parseq.Task;
import com.linkedin.project.Project;
import com.linkedin.project.ProjectInfo;
import com.linkedin.project.ProjectKey;
import com.linkedin.restli.common.ComplexResourceKey;
import com.linkedin.restli.common.EmptyRecord;
import com.linkedin.restli.server.annotations.*;
import com.linkedin.workflow.*;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.linkedin.metadata.restli.RestliConstants.*;

@RestLiCollection(name = "workflows", namespace = "com.linkedin.workflow", keyName = "workflow")
public final class Workflows extends BaseEntityResource<
        // @formatter:off
        WorkflowKey,
        Workflow,
        WorkflowUrn,
        WorkflowSnapshot,
        WorkflowAspect> {
    // @formatter:on

    @Inject
    @Named("workflowDao")
    private BaseLocalDAO _localDAO;

    public Workflows() {
        super(WorkflowSnapshot.class, WorkflowAspect.class);
    }

    @Override
    @Nonnull
    protected BaseLocalDAO getLocalDAO() {
        return _localDAO;
    }

    @Override
    @Nonnull
    protected WorkflowUrn toUrn(@Nonnull WorkflowKey key) {
        return new WorkflowUrn(key.getName());
    }

    @Override
    @Nonnull
    protected WorkflowKey toKey(@Nonnull WorkflowUrn urn) {
        return new WorkflowKey().setName(urn.getNameEntity());
    }

    @Override
    @Nonnull
    protected Workflow toValue(@Nonnull WorkflowSnapshot snapshot) {
        final Workflow value = new Workflow().setName(snapshot.getUrn().getNameEntity());
        ModelUtils.getAspectsFromSnapshot(snapshot).forEach(aspect -> {
            if (aspect instanceof WorkflowInfo) {
                value.setInfo(WorkflowInfo.class.cast(aspect));
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
    protected WorkflowSnapshot toSnapshot(@Nonnull Workflow workflow, @Nonnull WorkflowUrn workflowUrn) {
        final List<WorkflowAspect> aspects = new ArrayList<>();
        if (workflow.hasInfo()) {
            aspects.add(ModelUtils.newAspectUnion(WorkflowAspect.class, workflow.getInfo()));
        }
        return ModelUtils.newSnapshot(WorkflowSnapshot.class, workflowUrn, aspects);
    }

    @RestMethod.Get
    @Override
    @Nonnull
    public Task<Workflow> get(@Nonnull ComplexResourceKey<WorkflowKey, EmptyRecord> key,
                             @QueryParam(PARAM_ASPECTS) @Optional("[]") String[] aspectNames) {
        return super.get(key, aspectNames);
    }

    @RestMethod.BatchGet
    @Override
    @Nonnull
    public Task<Map<ComplexResourceKey<WorkflowKey, EmptyRecord>, Workflow>> batchGet(
            @Nonnull Set<ComplexResourceKey<WorkflowKey, EmptyRecord>> keys,
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