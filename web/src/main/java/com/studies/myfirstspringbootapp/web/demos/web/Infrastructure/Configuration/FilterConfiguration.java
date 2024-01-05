package com.studies.myfirstspringbootapp.web.demos.web.Infrastructure.Configuration;

import com.studies.myfirstspringbootapp.web.demos.web.Infrastructure.Filter.AuthorizationFilter;
import com.studies.myfirstspringbootapp.web.demos.web.Infrastructure.Filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * 筛选器配置
 */
@Configuration
public class FilterConfiguration {
    /**
     * LoginFilter筛选器注册Bean
     *
     * @return : LoginFilter筛选器注册Bean
     */
    @Bean
    public FilterRegistrationBean<LoginFilter> loginFilterFilterRegistrationBean() {
        return this.filterRegistrationBean(LoginFilter.class, "/*", 1);
    }

    /**
     * AuthorizationFilter筛选器注册Bean
     * 用AuthorizationInterceptor取代AuthorizationFilter
     * 若要使用AuthorizationFilter添加@Bean注解
     *
     * @return ：AuthorizationFilter筛选器注册Bean
     */
    public FilterRegistrationBean<AuthorizationFilter> authorizationFilterFilterRegistrationBean() {
        return this.filterRegistrationBean(AuthorizationFilter.class, "/*", 2);
    }

    /**
     * 建立筛选器注册Bean
     *
     * @param filterClass ：筛选器类
     * @param urlPatterns ：筛选器拦截Url模式
     * @param order       ：筛选器执行顺序,数字越小越先执行
     * @param <T>         ：筛选器类型
     * @return ：筛选器注册Bean
     */
    public <T extends Filter> FilterRegistrationBean<T> filterRegistrationBean(Class<T> filterClass, String urlPatterns, Integer order) {
        FilterRegistrationBean<T> filterRegistrationBean = new FilterRegistrationBean<>();

        filterRegistrationBean.setFilter(this.createInstance(filterClass));
        filterRegistrationBean.addUrlPatterns(urlPatterns);
        filterRegistrationBean.setOrder(order);

        return filterRegistrationBean;
    }

    /**
     * 建立类型T实例
     * @param tClass ：Class<T>
     * @return : 类型T实例
     * @param <T> ：要创建实例的类型
     */
    private <T> T createInstance(Class<T> tClass) {
        try {
            return tClass.getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("实例化Class<T>时发生异常", ex);
        }
    }
}
