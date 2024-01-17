package com.studies.myfirstspringbootapp;

import com.studies.myfirstspringbootapp.web.demos.web.Infrastructure.Configuration.AppConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import redis.clients.jedis.Jedis;

/**
 * 应用入口
 */
@Slf4j
@ServletComponentScan
@SpringBootApplication
public class WebApplication {
    /**
     * main
     *
     * @param args ：参数
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WebApplication.class, args);

        Jedis jedis = context.getBean(Jedis.class);
        log.info("current jedis is : {}", jedis);

        String value = jedis.getSet("hello", "world");
        if (value == null) {
            value = "world";
        }
        log.info("key hello value is : {}", value);
    }

}
