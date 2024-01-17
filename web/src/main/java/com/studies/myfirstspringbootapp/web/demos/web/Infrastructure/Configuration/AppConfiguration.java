package com.studies.myfirstspringbootapp.web.demos.web.Infrastructure.Configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 应用程序配置
 * 不使用[public,protected,private]访问修饰符，默认维护包访问权限，包内可访问
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
