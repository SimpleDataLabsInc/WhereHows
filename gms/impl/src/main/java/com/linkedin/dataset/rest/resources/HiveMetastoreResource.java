package com.linkedin.dataset.rest.resources;

import com.linkedin.common.InstitutionalMemory;
import com.linkedin.parseq.Task;
import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.annotations.RestMethod;
import hive.metastore.sdl.HiveMetastore;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nonnull;

/**
 * Rest.li entry point: /datasets/{datasetKey}/hiveMetastore
 */
@Slf4j
@RestLiCollection(name = "hiveMetastore", namespace = "com.linkedin.dataset", parent = Datasets.class)
public class HiveMetastoreResource extends BaseDatasetVersionedAspectResource<HiveMetastore> {
    public HiveMetastoreResource() {
        super(HiveMetastore.class);
    }

    @RestMethod.Get
    @Nonnull
    @Override
    public Task<HiveMetastore> get(@Nonnull Long version) {
        return super.get(version);
    }

    @RestMethod.Create
    @Nonnull
    @Override
    public Task<CreateResponse> create(@Nonnull HiveMetastore hiveMetastore) {
        return super.create(hiveMetastore);
    }
}
