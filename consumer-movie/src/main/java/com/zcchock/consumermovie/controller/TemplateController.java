
package com.zcchock.consumermovie.controller;

import com.zcchock.consumermovie.pojo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.userServiceUrl}")
    private String url;

    @GetMapping("/findUser")
    public UserEntity findOne(@RequestParam String id) {
        return this.restTemplate.getForObject(url + id, UserEntity.class);
    }

    @GetMapping("/user/{id}")
    public UserEntity findUser(@PathVariable String id) {
        return this.restTemplate.getForObject(url + id, UserEntity.class);
    }
}
