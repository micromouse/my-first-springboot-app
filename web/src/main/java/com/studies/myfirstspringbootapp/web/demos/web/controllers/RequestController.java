package com.studies.myfirstspringbootapp.web.demos.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.studies.myfirstspringbootapp.web.demos.web.models.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * 常用请求控制器
 */
@RestController
@RequestMapping("/request")
public class RequestController {
    /**
     * 简单get请求
     *
     * @param request ：HttpServletRequest对象
     * @return ：结果
     */
    @RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest request) {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        System.out.printf("name:%s,age:%s%n", name, age);
        return "ok";
    }

    /**
     * springboot自动解析的简单请求
     *
     * @param name ：名称
     * @param age  ：年龄
     * @return ：结果
     */
    @RequestMapping("/simpleParamSpringBoot")
    public String simpleParamBySpringBoot(String name, int age) {
        System.out.printf("name:%s,age:%s%n", name, age);
        return "ok";
    }

    /**
     * 带有RequestParam注解的简单请求
     *
     * @param userName ：用户名(形参名:name,必填)
     * @param age      : 年龄
     * @return ： 结果
     */
    @RequestMapping("/simpleParamByRequestParam")
    public String simpleParamByRequestParam(@RequestParam(name = "name", required = true) String userName, int age) {
        System.out.printf("userName:%s,age:%s%n", userName, age);
        return "ok";
    }

    /**
     * 数组请求
     *
     * @param hobbies ：爱好集合
     * @return : 结果
     */
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobbies) {
        System.out.printf("your hobby is : %s%n", Arrays.toString(hobbies));
        return "ok";
    }

    /**
     * List<T> 请求
     *
     * @param hobbies ： 爱好集合(必须要加上RequestParam注解)
     * @return ：结果
     */
    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobbies) {
        System.out.printf("your hobby is : %s%n", hobbies);
        return "ok";
    }

    /**
     * 日期请求
     *
     * @param requestTime ：请求时间
     * @return ：结果
     */
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss") LocalDateTime requestTime) {
        System.out.printf("request requestTime: %s%n", requestTime);
        return "ok";
    }

    /**
     * json请求
     *
     * @param user : 请求用户
     * @return : 结果
     */
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        System.out.printf("request user is : %s%n", json);
        return "ok";
    }

    /**
     * 路径参数请求
     *
     * @param name : 名称
     * @param id   : id
     * @return : 结果
     */
    @RequestMapping("/path/{name}/{id}")
    public String pathParam(@PathVariable String name, @PathVariable int id) {
        System.out.printf("request user %s's id is : %s%n", name, id);
        return "ok";
    }
}
