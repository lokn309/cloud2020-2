package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: lokn
 * @date: 2021/01/16 23:36
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routers = routeLocatorBuilder.routes();
        routers.route("path_rout",
                r ->r.path("/guonei").uri("http://news.baidu.com/")).build();
        return routers.build();
    }

}
