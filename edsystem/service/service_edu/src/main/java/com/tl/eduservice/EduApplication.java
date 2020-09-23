package com.tl.eduservice;

/**
 * *@Author tl
 *  @date 2020/09/16
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

//swagger访问地址：http://localhost:8001/swagger-ui.html
@ComponentScan(basePackages = {"com.tl"})
@EnableDiscoveryClient    //nacos注册
@EnableFeignClients        //Feign  服务调用
@MapperScan("com.tl.eduservice.mapper")
public class EduApplication {

    public static void main(String[] args) {

        SpringApplication.run(EduApplication.class,args);
    }

}
