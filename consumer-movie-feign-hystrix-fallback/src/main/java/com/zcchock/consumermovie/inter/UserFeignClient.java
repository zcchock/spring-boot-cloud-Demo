
package com.zcchock.consumermovie.inter;

import com.zcchock.consumermovie.pojo.UserEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@FeignClient(name = "provider-user", fallback = FeignClientFallback.class)
public interface UserFeignClient {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    UserEntity findById(@PathVariable("id") String id);

   /* @GetMapping("/mutUser")
    UserEntity getUser(@RequestParam("id") String id, @RequestParam("sex") String sex);

    @GetMapping("/mutUser")
    UserEntity getUser2(@RequestParam Map<String, Object> map);

    @PostMapping("/save")W
    void saveUser (@RequestBody UserEntity user);*/

}

@Component
class FeignClientFallback implements UserFeignClient {
    @Override
    public UserEntity findById(String id) {
        UserEntity user = new UserEntity();
        user.setId("-2");
        user.setName("feign error");
        user.setSex("9");
        user.setTall(0L);
        user.setBirthday(new Date());
        return user;
    }
}