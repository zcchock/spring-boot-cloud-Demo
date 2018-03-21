
package com.zcchock.consumermovie.inter;

import com.zcchock.consumermovie.pojo.UserEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "provider-user", configuration = FeignClientsConfiguration.class)
public interface UserFeignClient {

    @GetMapping("/user")
    UserEntity findById(@RequestParam("id") String id);
}
