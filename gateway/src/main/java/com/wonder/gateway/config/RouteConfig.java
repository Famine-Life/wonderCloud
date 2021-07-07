package com.wonder.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes().route(r -> r
                // 断言（判断条件）
                .path("/auth/**")
                // 目标 URI，路由到微服务的地址
                .uri("lb://auth")
                // 路由 ID，唯一
                .id("auth"))
                .route(r -> r.path("/api/personRepo/**").uri("lb://personRepo").id("personRepo"))
                .build();
    }

}
