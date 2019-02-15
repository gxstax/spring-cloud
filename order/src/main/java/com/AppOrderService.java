package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Ant
 * @ClassName: AppOrder
 * @Description: TODO
 * @datetime 2019/1/22 8:25
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class AppOrderService {
    public static void main(String[] args) {
        SpringApplication.run(AppOrderService.class);
    }
}
