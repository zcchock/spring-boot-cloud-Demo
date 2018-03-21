
package com.zcchock.consumermovie.inter;

import com.zcchock.consumermovie.pojo.UserEntity;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@FeignClient(name = "provider-user", fallbackFactory = FeignFallFactory.class)
public interface UserFeignClient {


    /*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    UserEntity findById(@PathVariable("id") String id);*/


    @GetMapping("/user")
    UserEntity findById(@RequestParam("id") String id);

    /*@GetMapping("/mutUser")
    UserEntity getUser(@RequestParam("id") String id, @RequestParam("sex") String sex);

    @GetMapping("/mutUser")
    UserEntity getUser2(@RequestParam Map<String, Object> map);

    @PostMapping("/save")
    void saveUser (@RequestBody UserEntity user);*/

}


@Component
class FeignFallFactory implements FallbackFactory<UserFeignClient> {
    private static final Logger logger = LoggerFactory.getLogger(FeignFallFactory.class);

    @Override
    public UserFeignClient create(Throwable throwable) {
        /*return new UserFeignClient() {
            @Override
            public UserEntity findById(String id) {
                FeignFallFactory.logger.info("fallback:; reason was:", throwable);
                UserEntity user = new UserEntity();
                if (throwable instanceof IllegalArgumentException){
                    user.setId("-1");
                } else {
                    user.setId("-2");
                }
                user.setName("feign error");
                user.setSex("9");
                user.setTall(0L);
                user.setBirthday(new Date());
                return user;
            }
        };*/
        return id -> {
            FeignFallFactory.logger.info("fallback:; reason was:", throwable);
            UserEntity user = new UserEntity();
            if (throwable instanceof IllegalArgumentException){
                    user.setId("-1");
                } else {
                    user.setId("-2");
                }
            user.setName("feign error");
            user.setSex("9");
            user.setTall(0L);
            user.setBirthday(new Date());
            return user;
        };
    }
}