
package com.zcchock.provideruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderUserMetadataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderUserMetadataApplication.class, args);
	}
}
