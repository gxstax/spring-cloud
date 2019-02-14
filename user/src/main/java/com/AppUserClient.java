package com;

import config.OrderRuleConfig;
import config.PowerRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Ant
 * @ClassName: AppUserClient
 * @Description: user客户端
 * @datetime 2019/1/18 8:18
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClients({
        @RibbonClient(name = "SERVER-POWER" , configuration = PowerRuleConfig.class),
        @RibbonClient(name = "SERVER-ORDER" , configuration = OrderRuleConfig.class)
})
@EnableFeignClients
@EnableHystrix
public class AppUserClient {
    public static void main(String[] args) {
        SpringApplication.run(AppUserClient.class);
    }
}
