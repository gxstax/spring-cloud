package com.ant.random;

import com.ant.ServerIps;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Ant
 * @ClassName: WeightRandom
 * @Description: 带权重的随机负载均衡算法
 * @datetime 2019/1/23 9:08
 * @Version 1.0
 */
public class WeightRandom {

    /**
     * 简单的list叠加，简单，适合小权重服务
     * 权重多的话，浪费空间，查找起来费时
     * @return
     */
    public static String getServerSimple() {
        // 把服务按权重依次放入
        List<String> serverLst = new ArrayList<>();
        for (String serverIp: ServerIps.WEIGHT_SERVER_LST.keySet()) {
            for (int i = 0; i < ServerIps.WEIGHT_SERVER_LST.get(serverIp); i++) {
                serverLst.add(serverIp);
            }
        }
        Random random = new Random();
        int pos = random.nextInt(serverLst.size());
        return serverLst.get(pos);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServerSimple());
        }
    }
}
