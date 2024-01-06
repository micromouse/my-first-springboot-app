package com.studies.myfirstspringbootapp.web.Controller;

import com.studies.myfirstspringbootapp.web.demos.web.models.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * ResponseController控制器测试
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ResponseControllerTest extends SpringBootTestBase {
    /**
     * @param environment  : 环境
     * @param restTemplate : TestRestTemplate
     */
    @Autowired
    public ResponseControllerTest(Environment environment, TestRestTemplate restTemplate) {
        super(environment, restTemplate);
    }

    /**
     * 请求ResponseController.success成功
     */
    @Test
    public void get_success_ok() {
        String url = String.format("http://localhost:%s/response/success", port);
        HttpEntity<?> httpEntity = this.getHttpEntity();

        ResponseEntity<ResultOfObject> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, ResultOfObject.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(200, response.getBody().getCode());
    }
}
