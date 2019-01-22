package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Ant
 * @ClassName: AppOrder1
 * @Description: AppOrder1
 * @datetime 2019/1/22 8:32
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class AppOrder1 {
    public static void main(String[] args) {
        SpringApplication.run(AppOrder1.class);
    }
}
