package com.ant.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Ant
 * @ClassName: PowerFeignClient
 * @Description: Feign调用客户端
 * @datetime 2019/1/22 9:08
 * @Version 1.0
 */
@FeignClient(name = "SERVER-POWER", fallbackFactory = FallBackFactory.class)
public interface PowerFeignClient {

    @RequestMapping(value = "/getPower.do", method = RequestMethod.GET)
    public Object getPower();
}
