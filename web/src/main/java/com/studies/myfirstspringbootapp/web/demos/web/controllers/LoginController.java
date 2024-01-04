package com.studies.myfirstspringbootapp.web.demos.web.controllers;

import com.studies.myfirstspringbootapp.common.JwtUtils;
import com.studies.myfirstspringbootapp.web.demos.web.models.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录控制器
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    /**
     * 登录系统
     *
     * @return ：结果
     */
    @PostMapping
    public Result<String> Login() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("name", "admin");
        claims.put("role", "manager");
        return Result.success(JwtUtils.generate(claims));
    }
}
