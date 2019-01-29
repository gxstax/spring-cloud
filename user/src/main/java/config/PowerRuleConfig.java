package config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ant
 * @ClassName: OrderRuleConfig
 * @Description: Power服务的ribbon负载均衡策略
 * @datetime 2019/1/22 8:48
 * @Version 1.0
 */
@Configuration
public class PowerRuleConfig {

    @Bean
    public IRule iRule() {
        return new RoundRobinRule();
    }
}
