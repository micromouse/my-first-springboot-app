package com.studies.myfirstspringbootapp.web.demos.web.Infrastructure.Filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 登录过滤器
 */
@Slf4j
@Order(1)
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
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
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("过滤器[LoginFilter]正在拦截请求:{}", ((HttpServletRequest) servletRequest).getRequestURL());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
