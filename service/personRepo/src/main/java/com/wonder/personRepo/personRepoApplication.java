package com.wonder.personRepo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("com.wonder.personRepo.mapper")
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.wonder")
public class personRepoApplication {
    public static void main(String[] args) {
        SpringApplication.run(personRepoApplication.class,args);
    }
}
