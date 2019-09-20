package com.linkedin.dataset.client;

import com.linkedin.common.client.DatasetsClient;
import com.linkedin.restli.client.Client;

import javax.annotation.Nonnull;

public class Metastores extends DatasetsClient {
    public Metastores(@Nonnull Client restliClient) {
        super(restliClient);
    }
}
