package com.wonder.auth;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.wonder")
@MapperScan("com.wonder.auth.mapper")
@ComponentScan("com.wonder")
public class authApplication {
    public static void main(String[] args) {
        SpringApplication.run(authApplication.class,args);
    }
}
