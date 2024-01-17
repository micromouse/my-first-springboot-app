package com.studies.myfirstspringbootapp.web.demos.web.Infrastructure.Configuration;

import com.studies.myfirstspringbootapp.web.demos.web.Infrastructure.Interceptor.AuthorizationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvc配置器
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    private final AuthorizationInterceptor authorizationInterceptor;

    /**
     * 初始化WebMvc配置器
     *
     * @param authorizationInterceptor ：授权拦截器
     */
    public WebMvcConfiguration(AuthorizationInterceptor authorizationInterceptor) {
        this.authorizationInterceptor = authorizationInterceptor;
    }

    /**
     * 添加拦截器
     *
     * @param registry ：拦截器注册
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor)
                .excludePathPatterns("/ordering/**")
                .excludePathPatterns("/**/favicon.ico")
                .excludePathPatterns("/**/error");
    }
}
