package com.studies.myfirstspringbootapp.web.demos.web.Infrastructure.Configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 应用程序配置
 */
@Configuration
public class AppConfiguration {
    /**
     * RestTemplate Bean
     *
     * @return ：RestTemplate Bean
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
