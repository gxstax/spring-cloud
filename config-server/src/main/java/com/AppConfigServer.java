package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Ant
 * @ClassName: AppConfigServer
 * @Description: AppConfigServer
 * @datetime 2019/2/18 8:38
 * @Version 1.0
 */

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class AppConfigServer {
    public static void main(String[] args) {
        SpringApplication.run(AppConfigServer.class);
    }
}
