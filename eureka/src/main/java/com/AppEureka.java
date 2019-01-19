package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Ant
 * @ClassName: AppEureka
 * @Description: AppEureka
 * @datetime 2019/1/19 12:14
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class AppEureka {
    public static void main(String[] args) {
        SpringApplication.run(AppEureka.class);
    }
}
