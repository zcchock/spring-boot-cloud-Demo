
package com.zcchock.consumermovie.controller;

import com.zcchock.consumermovie.pojo.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TemplateController {

    private static final Logger logger = LoggerFactory.getLogger(TemplateController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/findUser/{id}")
    public UserEntity findOne(@PathVariable String id) {
        return this.restTemplate.getForObject("http://provider-user/" + id, UserEntity.class);
    }

    @GetMapping("log-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("provider-user");

        TemplateController.logger.info("{}:{}:{}",
                serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }
}
