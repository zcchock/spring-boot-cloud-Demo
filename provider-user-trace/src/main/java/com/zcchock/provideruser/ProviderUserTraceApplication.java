
package com.zcchock.provideruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderUserTraceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderUserTraceApplication.class, args);
	}
}
