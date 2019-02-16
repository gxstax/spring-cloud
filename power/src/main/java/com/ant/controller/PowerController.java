package com.ant.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ant
 * @ClassName: PowerController
 * @Description: PowerController
 * @datetime 2019/1/18 8:41
 * @Version 1.0
 */
@RestController
public class PowerController {

    @RequestMapping("/getPower.do")
    public Object getPower(String name) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("key", "hello,user, this is power! 嘿嘿嘿...");
//        if(name == null) {
//            throw new Exception();
//        }
//        Thread.sleep(10000);
        return map;
    }
}
