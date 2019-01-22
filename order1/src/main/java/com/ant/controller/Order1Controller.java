package com.ant.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ant
 * @ClassName: OrderController
 * @Description: OrderController
 * @datetime 2019/1/22 8:27
 * @Version 1.0
 */
@RestController
public class Order1Controller {

    @RequestMapping("/getOrder.do")
    public Object getPower() {
        Map<String, Object> map = new HashMap<>();
        map.put("key", "hello, user, this is order111111111!");
        return map;
    }

}
