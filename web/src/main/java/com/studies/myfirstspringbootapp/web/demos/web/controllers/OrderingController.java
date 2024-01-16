package com.studies.myfirstspringbootapp.web.demos.web.controllers;

import com.studies.myfirstspringbootapp.web.demos.web.models.ServerConfig;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 订单控制器
 */
@RestController
@RequestMapping("/ordering")
public class OrderingController {
    private final RestTemplate restTemplate;

    /**
     * 初始化订单控制器
     *
     * @param restTemplate ：RestTemplate
     */
    public OrderingController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 从订单服务获得所有服务器配置信息
     *
     * @return ： 服务器配置信息集合
     */
    @RequestMapping("/all/{name}")
    public List<ServerConfig> list(@PathVariable String name) {
        String url = "http://orderingapi/serverConfig/all/" + name;
        ResponseEntity<List<ServerConfig>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ServerConfig>>() {
                });
        return response.getBody();
    }
}
