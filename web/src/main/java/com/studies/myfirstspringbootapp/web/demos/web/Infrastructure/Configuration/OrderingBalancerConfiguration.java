package com.studies.myfirstspringbootapp.web.demos.web.Infrastructure.Configuration;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClientConfiguration;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 订单服务负载均衡器配置
 */
@Configuration
public class OrderingBalancerConfiguration extends LoadBalancerClientConfiguration {
    /**
     * 获得订单服务负载均衡器
     *
     * @param environment               ：环境
     * @param loadBalancerClientFactory ：负载均衡器客户端工厂
     * @return ：随机负载均衡器
     */
    @Override
    public ReactorLoadBalancer<ServiceInstance> reactorServiceInstanceLoadBalancer(Environment environment, LoadBalancerClientFactory loadBalancerClientFactory) {
        String name = "orderingapi";
        ObjectProvider<ServiceInstanceListSupplier> provider =
                loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class);
        return new RandomLoadBalancer(provider, name);
    }
}
