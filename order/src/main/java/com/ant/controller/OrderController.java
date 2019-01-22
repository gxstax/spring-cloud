package com.ant.controller;

import com.ant.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
public class OrderController {

    @RequestMapping("/getOrder.do")
    public Object getPower() {
        Map<String, Object> map = new HashMap<>();
        map.put("key", "hello, user, this is order000000!");
        return map;
    }

}
