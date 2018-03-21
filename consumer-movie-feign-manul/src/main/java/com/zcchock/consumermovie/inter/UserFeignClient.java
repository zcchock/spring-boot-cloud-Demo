
package com.zcchock.consumermovie.inter;

import com.zcchock.consumermovie.pojo.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserFeignClient {

    @GetMapping("/user")
    UserEntity findById(@RequestParam("id") String id);
}
