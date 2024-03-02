package com.one.kubernetes.monitor.service;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1PodList;
import io.kubernetes.client.util.Config;
import org.springframework.stereotype.Service;

@Service
public class KubernetesService {
    private CoreV1Api api;

    public KubernetesService() throws Exception {
        ApiClient client = Config.defaultClient();
        Configuration.setDefaultApiClient(client);
        this.api = new CoreV1Api();
    }

    public V1PodList listPods(String namespace) throws ApiException {
        return api.listNamespacedPod(namespace, null, null, null, null, null, null, null, null, null, null);
    }
}
