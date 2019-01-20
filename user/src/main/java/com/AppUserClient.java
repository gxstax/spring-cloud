package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Ant
 * @ClassName: AppUserClient
 * @Description: user客户端
 * @datetime 2019/1/18 8:18
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class AppUserClient {
    public static void main(String[] args) {
        SpringApplication.run(AppUserClient.class);
    }
}
