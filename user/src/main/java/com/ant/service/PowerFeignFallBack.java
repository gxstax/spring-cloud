package com.ant.service;

import com.ant.util.R;
import lombok.Data;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @author Ant
 * @ClassName: PowerFeignFallBack
 * @Description: PowerFeignFallBack
 * @datetime 2019/2/15 13:06
 * @Version 1.0
 */


//@Component
public class PowerFeignFallBack implements PowerFeignClient{

    @Setter
    private Throwable cause;

    @Override
    public Object getPower() {
        return R.error(cause.getMessage());
    }
}
