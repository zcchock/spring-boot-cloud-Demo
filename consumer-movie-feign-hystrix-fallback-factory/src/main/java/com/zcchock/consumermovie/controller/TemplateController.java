
package com.zcchock.consumermovie.controller;

import com.zcchock.consumermovie.inter.UserFeignClient;
import com.zcchock.consumermovie.pojo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TemplateController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/findUser")
    public UserEntity findById(@RequestParam("id") String id) {
        return this.userFeignClient.findById(id);
    }

    /*@GetMapping("/findUserParams")
    public UserEntity findUserParams(@RequestParam("id") String id, @RequestParam("sex") String sex) {
        return this.userFeignClient.getUser(id, sex);
    }

    @GetMapping("/findUserParams2")
    public UserEntity findUserParams2(String id, String sex) {

        HashMap<String, Object> map = Maps.newHashMap();
        map.put("id", id);
        map.put("sex", sex);

        return this.userFeignClient.getUser2(map);
    }

    @PostMapping("/save")
    public void saveUser(@RequestBody UserEntity userEntity) {
        this.userFeignClient.saveUser(userEntity);
    }*/
}
