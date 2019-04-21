package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Ant
 * @ClassName: AppConfigClient
 * @Description: AppConfigClient
 * @datetime 2019/2/19 8:42
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class AppConfigClient {
    public static void main(String[] args) {
        SpringApplication.run(AppConfigClient.class);
    }
}
