package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Ant
 * @ClassName: AppConfigServer1
 * @Description: AppConfigServer1
 * @datetime 2019/2/20 8:32
 * @Version 1.0
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class AppConfigServer1 {
    public static void main(String[] args) {
        SpringApplication.run(AppConfigServer1.class);
    }
}
