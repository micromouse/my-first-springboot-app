package com.studies.myfirstspringbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

/**
 * 应用入口
 */
@ServletComponentScan
@SpringBootApplication
public class WebApplication {
    /**
     * main
     * @param args ：参数
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WebApplication.class, args);

        Jedis jedis = context.getBean(Jedis.class);
        System.out.println(jedis);

        String value = jedis.getSet("hello", "world");
        if (value == null) {
            value = "world";
        }
        System.out.printf("key hello value is : %s%n", value);
    }

}
