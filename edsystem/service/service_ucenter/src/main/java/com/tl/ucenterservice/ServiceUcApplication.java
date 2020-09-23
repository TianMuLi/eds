package com.tl.ucenterservice;
/**
 * @Author tl
 * @Date 2020/9/19
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.tl"})
@SpringBootApplication//取消数据源自动配置
@MapperScan("com.tl.ucenterservice.mapper")
@EnableDiscoveryClient    //nacos注册
public class ServiceUcApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceUcApplication.class, args);
    }
}
