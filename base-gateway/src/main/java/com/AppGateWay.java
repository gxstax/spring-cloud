package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p>
 * 功能描述
 * </p>
 *
 * @author Ant
 * @since 2020/8/26 9:30 下午
 */
@SpringBootApplication
@EnableEurekaServer
public class AppGateWay {
    public static void main(String[] args) {
        SpringApplication.run(AppGateWay.class, args);
    }
}
