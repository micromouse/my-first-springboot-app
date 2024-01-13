package com.studies.myfirstspringbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka应用程序
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
    /**
     * main
     *
     * @param args ：参数
     */
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class);
    }
}
