package com.studies.myfirstspringbootapp.web.Controller;

import com.studies.myfirstspringbootapp.web.demos.web.models.Result;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

/**
 * SpringBoot测试基类
 */
public class SpringBootTestBase {
    protected final String port;
    protected final TestRestTemplate restTemplate;

    /**
     * 初始化SpringBoot测试基类
     *
     * @param environment  : 环境
     * @param restTemplate : RestTemplate
     */
    protected SpringBootTestBase(Environment environment, TestRestTemplate restTemplate) {
        this.port = environment.getProperty("local.server.port");
        this.restTemplate = restTemplate;
    }

    /**
     * 获得请求认证头
     *
     * @return ：请求认证头
     */
    protected HttpEntity<?> getHttpEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MDQ1Mzc2NzcsInJvbGUiOiJtYW5hZ2VyIiwibmFtZSI6ImFkbWluIn0.52X7kLp9IQdD2WpX3CombRgdfN5reISryMZALcJRkxE");

        return new HttpEntity<>(httpHeaders);
    }

    /**
     * 数据类型为String的Result<T>类型
     */
    static class ResultOfString extends Result<String> {
    }

    static class ResultOfObject extends Result<Object> {
    }
}

