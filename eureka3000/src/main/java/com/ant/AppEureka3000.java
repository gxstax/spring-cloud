package com.ant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Ant
 * @ClassName: AppEureka3000
 * @Description: AppEureka3000
 * @datetime 2019/1/19 14:23
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class AppEureka3000 {
    public static void main(String[] args) {
        SpringApplication.run(AppEureka3000.class);
    }
}
