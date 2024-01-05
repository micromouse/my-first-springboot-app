package com.studies.myfirstspringbootapp.web.Controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

/**
 * BasicController控制器测试
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BasicControllerTest {
    private final String port;
    private final TestRestTemplate restTemplate;

    /**
     * 初始化BasicController测试
     *
     * @param environment  ：测试环境
     * @param restTemplate ：TestRestTemplate
     */
    @Autowired
    public BasicControllerTest(Environment environment, TestRestTemplate restTemplate) {
        this.port = environment.getProperty("local.server.port");
        this.restTemplate = restTemplate;
    }

    /**
     * get请求BasicController.hello成功
     */
    @Test
    public void get_hello_success() {
        String url = String.format("http://localhost:%s/basic/hello?name=world", port);

        //认证头
        HttpEntity<?> entity = new HttpEntity<>(new HttpHeaders() {{
            set("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MDQ0MjU1MzEsInJvbGUiOiJtYW5hZ2VyIiwibmFtZSI6ImFkbWluIn0.JNuOKl7C9JfiL5Vl_1kIMt4a1cnNmffNyt2GVZNtAt8");
        }});

        //请求
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        Assertions.assertEquals("Hello world", response.getBody());
    }
}
