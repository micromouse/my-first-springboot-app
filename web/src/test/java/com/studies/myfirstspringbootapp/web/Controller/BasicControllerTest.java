package com.studies.myfirstspringbootapp.web.Controller;

import com.studies.myfirstspringbootapp.web.demos.web.models.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.*;

/**
 * BasicController控制器测试
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BasicControllerTest extends SpringBootTestBase {
    /**
     * 初始化BasicController测试
     *
     * @param environment  ：测试环境
     * @param restTemplate ：TestRestTemplate
     */
    @Autowired
    public BasicControllerTest(Environment environment, TestRestTemplate restTemplate) {
        super(environment, restTemplate);
    }

    /**
     * get请求BasicController.hello成功
     */
    @Test
    public void get_hello_success() {
        String url = String.format("http://localhost:%s/basic/hello?name=world", port);
        ParameterizedTypeReference<Result<String>> resultType = new ParameterizedTypeReference<Result<String>>() {
        };
        HttpEntity<?> entity = this.getHttpEntity();

        ResponseEntity<Result<String>> response = restTemplate.exchange(url, HttpMethod.GET, entity, resultType);
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals("Hello world", response.getBody().getData());
    }

    /**
     * get请求BasicController.hello时name=guest发生未知异常
     */
    @Test
    public void get_hello_error_when_name_is_guest() {
        String url = String.format("http://localhost:%s/basic/hello?name=guest", port);
        HttpEntity<?> entity = this.getHttpEntity();

        ResponseEntity<ResultOfString> response = restTemplate.exchange(url, HttpMethod.GET, entity, ResultOfString.class);
        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(500, response.getBody().getCode());
    }
}
