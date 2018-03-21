
package com.zcchock.foc.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FocEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FocEurekaApplication.class, args);
    }
}
