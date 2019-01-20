package com.ant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Ant
 * @ClassName: AppEureka3002
 * @Description: AppEureka3002
 * @datetime 2019/1/19 16:16
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class AppEureka3002 {
    public static void main(String[] args) {
        SpringApplication.run(AppEureka3002.class);
    }
}
