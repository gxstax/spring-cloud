package com.ant.random;

import com.ant.ServerIps;

/**
 * @author Ant
 * @ClassName: Random
 * @Description: 随机负载均衡算法
 * @datetime 2019/1/23 9:03
 * @Version 1.0
 */
public class Random {

    public static String getServer(){
        java.util.Random random = new java.util.Random();
        int pos = random.nextInt(ServerIps.SERVER_LST.size());

        return ServerIps.SERVER_LST.get(pos);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
