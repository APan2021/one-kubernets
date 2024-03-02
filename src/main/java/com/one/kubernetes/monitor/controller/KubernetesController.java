package com.one.kubernetes.monitor.controller;

import com.one.kubernetes.monitor.service.KubernetesService;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.models.V1PodList;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kubernetes")
public class KubernetesController {
    @Autowired
    private KubernetesService kubernetesService;

    @GetMapping("/pods")
    public V1PodList getPods(@RequestParam String namespace) {
        try {
            if (StringUtils.isAllEmpty(namespace)){
                namespace = "default";
            }
            return kubernetesService.listPods(namespace);
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }
}
