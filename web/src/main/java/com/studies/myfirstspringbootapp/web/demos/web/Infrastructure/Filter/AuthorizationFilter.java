package com.studies.myfirstspringbootapp.web.demos.web.Infrastructure.Filter;

import com.alibaba.fastjson2.JSONObject;
import com.studies.myfirstspringbootapp.common.JwtUtils;
import com.studies.myfirstspringbootapp.web.demos.web.models.Result;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * 授权验证筛选器（拦截Servlet请求和响应，可以在请求到达Servlet之前进行处理，也可以在响应返回到客户端之前进行处理。）
 */
@Slf4j
public class AuthorizationFilter implements Filter {
    /**
     * 执行筛选
     *
     * @param servletRequest  ：请求
     * @param servletResponse ：响应
     * @param filterChain     ：筛选链路
     * @throws IOException      ：输入/输出异常
     * @throws ServletException ：Servlet异常
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        log.info("过滤器[AuthorizationFilter]正在拦截请求:{}", request.getRequestURL());
        filterChain.doFilter(servletRequest, servletResponse);
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
