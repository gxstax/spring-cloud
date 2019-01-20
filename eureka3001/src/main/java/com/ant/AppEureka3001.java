package com.ant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Ant
 * @ClassName: AppEureka3001
 * @Description: TODO
 * @datetime 2019/1/19 16:14
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class AppEureka3001 {
    public static void main(String[] args) {
        SpringApplication.run(AppEureka3001.class);
    }
}
