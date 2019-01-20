package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: AppPower1Server
 * @Description: Power1启动类
 * @datetime 2019/1/18 9:40
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class AppPower1Server {
    public static void main(String[] args) {
        SpringApplication.run(AppPower1Server.class);
    }
}
