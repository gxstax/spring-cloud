package com.ant.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ant
 * @ClassName: PowerFeignClient
 * @Description: Feign调用客户端
 * @datetime 2019/1/22 9:08
 * @Version 1.0
 */
@FeignClient(name = "SERVER-POWER")
@Component
public interface PowerFeignClient {

    @RequestMapping("/getPower.do")
    public Object getPower();
}
