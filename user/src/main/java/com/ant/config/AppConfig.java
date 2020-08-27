package com.ant.config;

import com.ant.rule.AntRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Ant
 * @ClassName: AppConfig
 * @Description: 配置类
 * @datetime 2019/1/15 20:43
 * @Version 1.0
 */
@Configuration
@ComponentScan("com")
public class AppConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public IRule iRule(){
//        return new AntRule();
//    }

//    @Bean
//    public TomcatServletWebServerFactory tomcat() {
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//        tomcat.setPort(5000);
//        return tomcat;
//    }

}
