
package com.zcchock.consumermovie.inter;

import com.zcchock.consumermovie.config.FeignConfiguration;
import com.zcchock.consumermovie.pojo.UserEntity;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "provider-user", configuration = FeignConfiguration.class)
public interface UserFeignClient {

    @RequestLine("GET /user")
    UserEntity findById(@RequestParam("id") String id);

    @RequestLine("GET /{id}")
    UserEntity findUserById(@Param("id") String id);
}
