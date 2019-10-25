package com.ant.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 功能描述
 * </p>
 *
 * @author GaoXin
 * @since 2019-10-24 19:39
 */
@Component
public class FallBackFactory implements FallbackFactory<PowerFeignClient> {

    @Override
    public PowerFeignClient create(Throwable throwable) {
        System.out.println("调用了降级方法。。。。。");
        if (throwable !=null) {
            System.out.println(throwable);
            return null;
        }
        return null;
    }
}
