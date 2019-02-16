package com.ant.service;

import com.ant.util.R;
import org.springframework.stereotype.Component;

/**
 * @author Ant
 * @ClassName: PowerFeignFallBack
 * @Description: PowerFeignFallBack
 * @datetime 2019/2/15 13:06
 * @Version 1.0
 */

@Component
public class PowerFeignFallBack implements PowerFeignClient{
    @Override
    public Object getPower() {
        return R.error("Power 服务暂时不可用!!!");
    }
}
