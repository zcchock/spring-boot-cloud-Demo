
package com.zcchock.consumermovie.test;

import com.zcchock.consumermovie.config.RibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name = "provider-user", configuration = RibbonConfiguration.class)
public class TestConfiguration {
}
