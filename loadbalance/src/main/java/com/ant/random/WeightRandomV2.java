package com.ant.random;

import com.ant.ServerIps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author Ant
 * @ClassName: WeightRandom
 * @Description: 带权重的随机负载均衡算法
 * @datetime 2019/1/23 9:08
 * @Version 1.0
 */
public class WeightRandomV2 {

    /**
     * 使用坐标概念来确定随机的服务
     * @return
     */
    public static String getServerSimple() {
        boolean sameWeight = true;
        // 计算权重
        int totalWeight = 0;
        for (int ldx = 0; ldx < ServerIps.WEIGHT_SERVER_LST.size(); ldx++) {
            int weight= (int) ServerIps.WEIGHT_SERVER_LST.values().toArray()[ldx];
            totalWeight += weight;
            if(sameWeight && ldx > 0 && (weight!=(int)ServerIps.WEIGHT_SERVER_LST.values().toArray()[ldx-1])) {
                sameWeight = false;
            }
        }

        Random random = new Random();
        // 如果服务权重相同，则使用简单的随机算法
        int pos = 0;
        if (sameWeight) {
            pos = random.nextInt(ServerIps.WEIGHT_SERVER_LST.size());
            return (String)ServerIps.WEIGHT_SERVER_LST.keySet().toArray()[pos];
        }
        // 如果权重不相同，从权重和范围内随机一个整数
        pos = random.nextInt(totalWeight);
        // 判定随机数落到的区间，并取出该区间范围的服务器地址
        for (String serverIp:ServerIps.WEIGHT_SERVER_LST.keySet()) {
            int currWeight = ServerIps.WEIGHT_SERVER_LST.get(serverIp);
            if (pos < currWeight) {
                return serverIp;
            }
            pos -= currWeight;
        }
        return "";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServerSimple());
        }
    }
}
