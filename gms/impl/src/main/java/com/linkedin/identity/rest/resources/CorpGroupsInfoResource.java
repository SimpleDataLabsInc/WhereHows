package com.linkedin.identity.rest.resources;

import com.linkedin.identity.CorpGroupInfo;
import com.linkedin.parseq.Task;
import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.annotations.Optional;
import com.linkedin.restli.server.annotations.QueryParam;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.annotations.RestMethod;
import javax.annotation.Nonnull;


/**
 * Rest.li entry point: /corpGroups/{corpGroupKey}/info
 */
@RestLiCollection(name = "info", namespace = "com.linkedin.identity", parent = CorpGroups.class)
public final class CorpGroupsInfoResource extends BaseCorpGroupsAspectResource<CorpGroupInfo> {

    public CorpGroupsInfoResource() {
        super(CorpGroupInfo.class);
    }

    @Nonnull
    @Override
    @RestMethod.Create
    public Task<CreateResponse> create(@Nonnull CorpGroupInfo corpGroupInfo) {
        return super.create(corpGroupInfo);
    }

    @Nonnull
    @Override
    @RestMethod.Get
    public Task<CorpGroupInfo> get(@QueryParam("version") @Optional("0") @Nonnull Long version) {
        return super.get(version);
    }
}