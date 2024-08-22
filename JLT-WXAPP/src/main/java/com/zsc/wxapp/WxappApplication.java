package com.zsc.wxapp;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@EnableFeignClients(basePackages = "com.zsc.wxapp.clients")
@SpringBootApplication
@MapperScan("com.zsc.wxapp.mapper")
public class WxappApplication {
    public static void main(String[] args) {
        SpringApplication.run(WxappApplication.class, args);
    }
}
