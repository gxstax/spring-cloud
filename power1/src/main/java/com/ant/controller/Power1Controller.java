package com.ant.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: Power1Controller
 * @Description: Power1Controller
 * @datetime 2019/1/18 9:42
 * @Version 1.0
 */
@RestController
public class Power1Controller {

    @RequestMapping("/getPower.do")
    public Object getPower1() {
        Map<String, Object> map = new HashMap<>();
        map.put("key", "hello,user, this is power11111111! 嘿嘿嘿...");
        return map;
    }
}
