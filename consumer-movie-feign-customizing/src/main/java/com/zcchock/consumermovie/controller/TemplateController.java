
package com.zcchock.consumermovie.controller;

import com.zcchock.consumermovie.inter.UserFeignClient;
import com.zcchock.consumermovie.pojo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemplateController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/findUser")
    public UserEntity findById(@RequestParam("id") String id) {
        return this.userFeignClient.findById(id);
    }

    @GetMapping("/user/{id}")
    public UserEntity findUserById(@PathVariable("id") String id) {
        return this.userFeignClient.findUserById(id);
    }
}
