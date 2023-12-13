package com.studies.myfirstspringbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import redis.clients.jedis.Jedis;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WebApplication.class, args);

        Jedis jedis = context.getBean(Jedis.class);
        System.out.println(jedis);

        //设置值
        jedis.set("hello", "world");

        //获取值
        String value = jedis.get("hello");
        System.out.printf("key hellow value is : %s%n", value);
    }

}
