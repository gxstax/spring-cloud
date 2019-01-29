package com.ant.poll;

import com.ant.ServerIps;
import java.util.Set;

/**
 * @author Ant
 * @ClassName: WeightPolling
 * @Description: 带有权重的轮询
 * @datetime 2019/1/25 8:45
 * @Version 1.0
 */
public class WeightPolling {

    static Set<String> KEY_SET = ServerIps.WEIGHT_SERVER_LST.keySet();
    static Object[] SERVER_STR_ARR = ServerIps.WEIGHT_SERVER_LST.keySet().toArray();
    static Object[] SERVER_INT_ARR = ServerIps.WEIGHT_SERVER_LST.values().toArray();

    public static String getServerIp () {

        // 每个服务的权重是否相同标识
        boolean sameWeight = true;
        // 计算权重
        int totalWeight = 0;
        for (int ldx = 0; ldx < ServerIps.WEIGHT_SERVER_LST.size(); ldx++) {
            int weight= (int) SERVER_INT_ARR[ldx];
            totalWeight += weight;
            if(sameWeight && ldx > 0 && (weight!=(int)SERVER_INT_ARR[ldx-1])) {
                sameWeight = false;
            }
        }

        int queueNum = Sequeue.getAndIncrement();
        int pos = queueNum % totalWeight;

        if(sameWeight) {
            pos = queueNum % ServerIps.WEIGHT_SERVER_LST.size();
            return SERVER_STR_ARR[pos].toString();
        }

        // 判定权重值落到的区间，并取出该区间范围的服务器地址
        for (String serverIp:KEY_SET) {
            int currWeight = ServerIps.WEIGHT_SERVER_LST.get(serverIp);
            if (pos < currWeight) {
                return serverIp;
            }
            pos -= currWeight;
        }

        return null;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(getServerIp());
        }
    }
}
