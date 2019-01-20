package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Ant
 * @ClassName: AppPowerServer
 * @Description: Power启动类
 * @datetime 2019/1/18 8:35
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class AppPowerServer {
    public static void main(String[] args) {
        SpringApplication.run(AppPowerServer.class);
    }
}
