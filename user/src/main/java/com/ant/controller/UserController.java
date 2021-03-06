package com.ant.controller;

import com.ant.service.PowerFeignClient;
import com.ant.util.R;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ant
 * @ClassName: UserController
 * @Description: 客户端Controller
 * @datetime 2019/1/18 8:24
 * @Version 1.0
 */
@RestController
public class UserController {

    private static final String POWER_URL= "http://SERVER-POWER";

    private static final String ORDER_URL= "http://SERVER-ORDER";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private PowerFeignClient powerFeignClient;

    @RequestMapping("/getUser")
    public R getUser() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key", "用户数据");
        return R.success("返回成功", map);
    }

    @RequestMapping("/getOrder")
    public R getOrder() {
        return R.success("操作成功", restTemplate.getForObject(ORDER_URL + "/getOrder.do", Object.class));
    }

    @RequestMapping("/getPower")
    @HystrixCommand(fallbackMethod = "getFeignFallBack", threadPoolKey ="power",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "5")
            }
    )
    public R getPower() {
        System.out.println("调用了getPower()方法......");
        return R.success("操作成功", restTemplate.getForObject(POWER_URL + "/getPower.do", Object.class));
    }


    @RequestMapping(value = "/getFeign", method = RequestMethod.GET)
//    @HystrixCommand(threadPoolKey = "getFeigns",
//        threadPoolProperties = { @HystrixProperty(name = "coreSize", value = "5")}
//    )
//    @HystrixCommand(
//            commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
//                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3"),
//                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
//            },
//            threadPoolProperties = {
//                    @HystrixProperty(name = "coreSize", value = "5"),
//                    @HystrixProperty(name = "maxQueueSize", value = "101"),
//                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
//                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
//                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
//                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440")
//            })
    public R getFeign() {
//        System.out.println("调用了该方法......");
        return R.success("操作成功", powerFeignClient.getPower());
    }



    public R getFeignFallBack() {
        return R.error("系统维护中!!!请稍后重试!!!");
    }
}
