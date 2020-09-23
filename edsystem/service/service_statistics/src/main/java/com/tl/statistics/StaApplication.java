package com.tl.statistics;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author tl
 * @Date 2020/9/22
 */

@SpringBootApplication
@MapperScan("com.tl.statistics.mapper")
@ComponentScan(basePackages = {"com.tl"})
@EnableFeignClients
@EnableDiscoveryClient
@EnableScheduling
public class StaApplication {
    public static void main(String[] args) {
        SpringApplication.run(StaApplication.class, args);
    }
}
