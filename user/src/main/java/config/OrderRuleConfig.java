package config;

import com.ant.rule.AntRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ant
 * @ClassName: OrderRuleConfig
 * @Description: Order服务的ribbon负载均衡策略
 * @datetime 2019/1/22 8:48
 * @Version 1.0
 */
@Configuration
public class OrderRuleConfig {

    @Bean
    public IRule iRule() {
        return new AntRule();
    }
}
