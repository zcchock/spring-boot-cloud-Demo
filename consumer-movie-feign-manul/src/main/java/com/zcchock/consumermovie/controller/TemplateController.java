
package com.zcchock.consumermovie.controller;

import com.zcchock.consumermovie.inter.UserFeignClient;
import com.zcchock.consumermovie.pojo.UserEntity;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Import(FeignClientsConfiguration.class)
@RestController
public class TemplateController {

    private UserFeignClient userUserFeignClient;

    private UserFeignClient adminUserFeignClient;

    @Autowired
    public TemplateController(Decoder decoder, Encoder encoder, Client client, Contract contract){

        this.userUserFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("user", "pass"))
                .target(UserFeignClient.class, "http://provider-user/");

        this.adminUserFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("admin", "admin"))
                .target(UserFeignClient.class, "http://provider-user/");
    }


    @GetMapping("/user-user/{id}")
    public UserEntity findUserById(@PathVariable("id") String id) {
        return this.userUserFeignClient.findById(id);
    }

    @GetMapping("/user-admin/{id}")
    public UserEntity findAdminById(@PathVariable("id") String id) {
        return this.adminUserFeignClient.findById(id);
    }
}
