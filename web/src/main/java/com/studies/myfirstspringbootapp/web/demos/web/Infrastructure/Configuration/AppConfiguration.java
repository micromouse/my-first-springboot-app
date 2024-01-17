package com.studies.myfirstspringbootapp.web.demos.web.Infrastructure.Configuration;
/*
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
*/
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 应用程序配置
 */
@Configuration
public class AppConfiguration {
    /**
     * RestTemplate Bean
     *
     * @return ：RestTemplate Bean
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 全局负载均衡器
     * 配置key[orderingapi.ribbon.NFLoadBalancerRuleClassName]值为com.netflix.loadbalancer.RandomRule才注册
     *
     * @return ：全局使用随机负载均衡器
     */
    /*
    public IRule randomRule() {
        return new RandomRule();
    }
    */
}
