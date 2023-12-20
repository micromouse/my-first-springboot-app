package com.studies.myfirstspringbootapp.web.demos.web.controllers;

import com.studies.myfirstspringbootapp.web.demos.web.models.Result;
import com.studies.myfirstspringbootapp.web.demos.web.models.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 响应控制器
 */
@RestController
@RequestMapping("/response")
public class ResponseController {
    /**
     * 成功响应
     *
     * @return : 响应结果
     */
    @RequestMapping("/success")
    public Result<Object> success() {
        return Result.success();
    }

    /**
     * hello响应
     *
     * @return : 响应结果
     */
    @RequestMapping("/hello")
    public Result<String> hello() {
        return Result.success("hello world!");
    }

    /**
     * 错误响应
     *
     * @return : 响应结果
     */
    @RequestMapping("/error")
    public Result<Object> error() {
        Result<Object> result = Result.error("error message");
        System.out.printf("response result is : %s%n", result);
        return result;
    }

    /**
     * 用户信息响应
     * @return : 响应结果
     */
    @RequestMapping("/user")
    public Result<User> user() {
        User user = new User();
        user.setName("zhangsan");
        user.setAge(20);
        System.out.printf("response user is : %s%n", user);
        return Result.success(user);
    }
}
