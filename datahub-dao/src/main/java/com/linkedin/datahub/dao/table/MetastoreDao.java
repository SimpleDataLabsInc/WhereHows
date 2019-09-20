package com.linkedin.datahub.dao.table;

import com.linkedin.dataset.client.Datasets;
import com.linkedin.dataset.client.Lineages;
import com.linkedin.dataset.client.Metastores;

import javax.annotation.Nonnull;

public class MetastoreDao {
    private final Metastores _metastores;
    private final Datasets _datasets;

    public MetastoreDao(@Nonnull Metastores metastores, @Nonnull Datasets datasets) {
        _metastores = metastores;
        _datasets = datasets;
    }
}
