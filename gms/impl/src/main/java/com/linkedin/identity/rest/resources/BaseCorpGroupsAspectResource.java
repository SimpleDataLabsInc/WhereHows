package com.linkedin.identity.rest.resources;

import com.linkedin.common.urn.CorpGroupUrn;
import com.linkedin.data.template.RecordTemplate;
import com.linkedin.identity.CorpGroupKey;
import com.linkedin.metadata.aspect.CorpGroupAspect;
import com.linkedin.metadata.dao.BaseLocalDAO;
import com.linkedin.metadata.restli.BaseVersionedAspectResource;
import com.linkedin.restli.common.ComplexResourceKey;
import com.linkedin.restli.common.EmptyRecord;
import com.linkedin.restli.server.PathKeys;
import com.linkedin.restli.server.annotations.PathKeysParam;
import com.linkedin.restli.server.annotations.RestLiCollection;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Named;

public class BaseCorpGroupsAspectResource<ASPECT extends RecordTemplate>
        extends BaseVersionedAspectResource<CorpGroupUrn, CorpGroupAspect, ASPECT> {

    private static final String CORPGROUP_KEY = CorpGroups.class.getAnnotation(RestLiCollection.class).keyName();

    public BaseCorpGroupsAspectResource(Class<ASPECT> aspectClass) {
        super(CorpGroupAspect.class, aspectClass);
    }

    @Inject
    @Named("corpGroupDao")
    private BaseLocalDAO localDAO;

    @Nonnull
    @Override
    protected BaseLocalDAO getLocalDAO() {
        return localDAO;
    }

    @Nonnull
    @Override
    protected CorpGroupUrn getUrn(@PathKeysParam @Nonnull PathKeys keys) {
        return new CorpGroupUrn(keys.<ComplexResourceKey<CorpGroupKey, EmptyRecord>>get(CORPGROUP_KEY).getKey().getName());
    }
}