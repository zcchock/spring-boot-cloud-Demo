
package com.zcchock.provideruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderUserAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderUserAuthApplication.class, args);
	}
}
