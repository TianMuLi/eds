package com.tl.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


/**
 * @Author tl
 * @Date 2020/9/18
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)

@ComponentScan({"com.tl"})

public class OssApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class, args);
    }
}