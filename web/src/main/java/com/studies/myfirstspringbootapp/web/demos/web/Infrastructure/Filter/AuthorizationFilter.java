package com.studies.myfirstspringbootapp.web.demos.web.Infrastructure.Filter;

import com.github.pagehelper.BoundSqlInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 授权验证筛选器
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
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("过滤器[AuthorizationFilter]正在拦截请求:{}", ((HttpServletRequest) servletRequest).getRequestURL());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
