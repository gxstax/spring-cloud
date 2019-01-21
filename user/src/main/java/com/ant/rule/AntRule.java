package com.ant.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import java.util.List;
import java.util.Random;

/**
 * @author Ant
 * @ClassName: AntRule
 * @Description: 自定义客户端负载均衡Rule
 * @datetime 2019/1/21 9:07
 * @Version 1.0
 */
public class AntRule extends AbstractLoadBalancerRule {

    // 当前服务的下标
    private int nowIndexVal = -1;
    // 上一次服务的下标
    private int lstIndexVal = -1;
    // 需要跳过的下标
    private int skipIndexVal = -1;

    Random rand = new Random();

    public AntRule() {
    }

    /**
     * 伪随机，当一个下标的服务连续被调用两次，如果下一次还是它，则跳过重新随机一个新的
     * @param lb
     * @param key
     * @return
     */
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

                int index = this.rand.nextInt(serverCount);

                // 如果这次随机的是需要跳过的下标，则重新随机一个新的下标
                if(index == skipIndexVal){
                    index = this.rand.nextInt(serverCount);
                    skipIndexVal = -1;
                    lstIndexVal = -1;
                }

                nowIndexVal = index;
                // 如果当前下标和上一次下标相同，则下次需要跳过的下标则是当前下标
                if(nowIndexVal == lstIndexVal) {
                    skipIndexVal = nowIndexVal;
                    System.out.println("需要跳过的下标-->" + skipIndexVal);
                }

                lstIndexVal = index;
                server = (Server)upList.get(index);
                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
