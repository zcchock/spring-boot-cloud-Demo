
package com.zcchock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulGateWayFallBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGateWayFallBackApplication.class, args);
	}
}
