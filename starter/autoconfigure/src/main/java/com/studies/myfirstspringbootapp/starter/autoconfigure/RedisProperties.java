package com.studies.myfirstspringbootapp.starter.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Redis配置属性
 */
@ConfigurationProperties("spring.redis")
public class RedisProperties {
    /*
    主机名/IP
     */
    private String host = "localhost";
    /*
    主机端口
     */
    private int port = 6379;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
