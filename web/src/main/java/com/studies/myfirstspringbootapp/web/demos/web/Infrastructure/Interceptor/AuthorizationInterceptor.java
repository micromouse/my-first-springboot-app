package com.studies.myfirstspringbootapp.web.demos.web.Infrastructure.Interceptor;

import com.alibaba.fastjson2.JSONObject;
import com.studies.myfirstspringbootapp.common.JwtUtils;
import com.studies.myfirstspringbootapp.web.demos.web.models.Result;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * 授权拦截器(拦截Spring MVC中Controller的处理过程，包括Controller方法的调用前后等。)
 */
@Slf4j
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {
    /**
     * 资源请求前预处理
     *
     * @param request  ：请求
     * @param response ：响应
     * @param handler  ：处理器
     * @return ：处理结果(true:继续资源请求处理，false：直接返回结果)
     * @throws Exception ：异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("拦截器[AuthorizationInterceptor]正在拦截请求:{}", request.getRequestURL());

        //请求url需要验证token
        if (!this.shouldCheckToekn(request)) {
            String token = request.getHeader("Authorization");
            if (token.startsWith("Bearer ")) {
                token = token.substring("Bearer ".length());
            }

            //解析jwt token
            Optional<Claims> claims = JwtUtils.tryParse(token);
            if (!claims.isPresent()) {
                //验证失败
                log.error("当前请求token[{}]验证失败", token);
                response.getWriter().write(JSONObject.toJSONString(Result.error("not login")));
                return false;
            }

            log.info("当前请求是合法请求，请求用户为：[{}]", claims);
        }

        //请求不需要验证token或token合法
        return true;
    }

    /**
     * 请求url是否应该被验证token
     *
     * @param request ：请求
     * @return ：请求url是否应该被验证token
     */
    private boolean shouldCheckToekn(HttpServletRequest request) {
        return request.getRequestURI().equals(request.getContextPath() + "/login");
    }
}
