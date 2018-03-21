
package com.zcchock.consumermovie.inter;

import com.zcchock.consumermovie.pojo.UserEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "provider-user")
public interface UserFeignClient {

    @GetMapping("/user")
    UserEntity findById(@RequestParam("id") String id);

    @GetMapping("/mutUser")
    UserEntity getUser(@RequestParam("id") String id, @RequestParam("sex") String sex);

    @GetMapping("/mutUser")
    UserEntity getUser2(@RequestParam Map<String, Object> map);

    @PostMapping("/save")
    void saveUser (@RequestBody UserEntity user);

}
