package com.linkedin.identity.rest.resources;

import com.linkedin.common.urn.CorpGroupUrn;
import com.linkedin.identity.*;
import com.linkedin.metadata.aspect.CorpGroupAspect;
import com.linkedin.metadata.dao.BaseLocalDAO;
import com.linkedin.metadata.dao.utils.ModelUtils;
import com.linkedin.metadata.restli.BaseEntityResource;
import com.linkedin.metadata.snapshot.CorpGroupSnapshot;
import com.linkedin.parseq.Task;
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

@RestLiCollection(name = "corpGroups", namespace = "com.linkedin.identity", keyName = "corpGroup")
public final class CorpGroups extends BaseEntityResource<
        // @formatter:off
        CorpGroupKey,
        CorpGroup,
        CorpGroupUrn,
        CorpGroupSnapshot,
        CorpGroupAspect> {
    // @formatter:on

    @Inject
    @Named("corpGroupDao")
    private BaseLocalDAO _localDAO;

    public CorpGroups() {
        super(CorpGroupSnapshot.class, CorpGroupAspect.class);
    }

    @Override
    @Nonnull
    protected BaseLocalDAO getLocalDAO() {
        return _localDAO;
    }

    @Override
    @Nonnull
    protected CorpGroupUrn toUrn(@Nonnull CorpGroupKey key) {
        return new CorpGroupUrn(key.getName());
    }

    @Override
    @Nonnull
    protected CorpGroupKey toKey(@Nonnull CorpGroupUrn urn) {
        return new CorpGroupKey().setName(urn.getGroupNameEntity());
    }

    @Override
    @Nonnull
    protected CorpGroup toValue(@Nonnull CorpGroupSnapshot snapshot) {
        final CorpGroup value = new CorpGroup().setName(snapshot.getUrn().getGroupNameEntity());
        ModelUtils.getAspectsFromSnapshot(snapshot).forEach(aspect -> {
            if (aspect instanceof CorpGroupInfo) {
                value.setInfo(CorpGroupInfo.class.cast(aspect));
            }
        });
        return value;
    }

    @Override
    @Nonnull
    protected CorpGroupSnapshot toSnapshot(@Nonnull CorpGroup corpGroup, @Nonnull CorpGroupUrn CorpGroupUrn) {
        final List<CorpGroupAspect> aspects = new ArrayList<>();
        if (corpGroup.hasInfo()) {
            aspects.add(ModelUtils.newAspectUnion(CorpGroupAspect.class, corpGroup.getInfo()));
        }
        return ModelUtils.newSnapshot(CorpGroupSnapshot.class, CorpGroupUrn, aspects);
    }

    @RestMethod.Get
    @Override
    @Nonnull
    public Task<CorpGroup> get(@Nonnull ComplexResourceKey<CorpGroupKey, EmptyRecord> key,
                              @QueryParam(PARAM_ASPECTS) @Optional("[]") String[] aspectNames) {
        return super.get(key, aspectNames);
    }

    @RestMethod.BatchGet
    @Override
    @Nonnull
    public Task<Map<ComplexResourceKey<CorpGroupKey, EmptyRecord>, CorpGroup>> batchGet(
            @Nonnull Set<ComplexResourceKey<CorpGroupKey, EmptyRecord>> keys,
            @QueryParam(PARAM_ASPECTS) @Optional("[]") String[] aspectNames) {
        return super.batchGet(keys, aspectNames);
    }
}