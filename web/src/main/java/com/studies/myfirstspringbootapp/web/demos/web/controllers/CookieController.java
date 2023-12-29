package com.studies.myfirstspringbootapp.web.demos.web.controllers;

import com.studies.myfirstspringbootapp.web.demos.web.models.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * cookie控制器
 */
@RestController
@RequestMapping("/cookies")
public class CookieController {
    /**
     * 设置cookie
     *
     * @param response : http响应对象(自动哪个注入)
     * @param name     ：cookie名
     * @param value    ：cookie值
     * @return ：结果
     */
    @PostMapping
    public Result<String> set(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        response.addCookie(cookie);
        return Result.success("已成功发送cookie");
    }

    /**
     * 获得所有cookie集合
     *
     * @param request ：http请求对象
     * @return ：cookie集合
     */
    @RequestMapping
    public Result<HashMap<String, String>> getAll(HttpServletRequest request) {
        HashMap<String, String> datas = new HashMap<>();

        for (Cookie cookie : request.getCookies()) {
            datas.put(cookie.getName(), cookie.getValue());
        }
        return Result.success(datas);
    }
}