package com.ant.poll;

import com.ant.ServerIps;
import com.ant.util.AntTuple_3;

/**
 * @author Ant
 * @ClassName: SmoothWeightPolling
 * @Description: 平滑加权轮询算法
 * @datetime 2019/1/28 9:08
 * @Version 1.0
 */
public class SmoothWeightPolling {

    public static int currentWeight;//当前服务权重值

    public static int totalWeight = 0;//总权重

    public static Object[] objArr = ServerIps.WEIGHT_SERVER_LST.values().toArray();

    public static Object[] keyVal = ServerIps.WEIGHT_SERVER_LST.keySet().toArray();

    // 原始权重对象
    public static AntTuple_3 WEIGHT_TUPLE = new AntTuple_3();

    // 计算之后的权重对象
    public static AntTuple_3 CUL_WEIGHT_TUPLE = new AntTuple_3(objArr[0],objArr[1],objArr[2]);

    public static String getServerIp(int i) {
        String serverIp = "";
        //计算总权重
        for (Object key : keyVal) {
            String keyStr = key.toString();
            if (keyStr.equals("A")) WEIGHT_TUPLE.setA(ServerIps.WEIGHT_SERVER_LST.get(keyStr));
            if (keyStr.equals("B")) WEIGHT_TUPLE.setB(ServerIps.WEIGHT_SERVER_LST.get(keyStr));
            if (keyStr.equals("C")) WEIGHT_TUPLE.setC(ServerIps.WEIGHT_SERVER_LST.get(keyStr));

            totalWeight += ServerIps.WEIGHT_SERVER_LST.get(keyStr);
        }
        String caseVal = CUL_WEIGHT_TUPLE.getMaxValue(CUL_WEIGHT_TUPLE);
        serverIp = caseVal;
        System.out.print(serverIp + "  ");
        if(i % 7 == 0) {
            System.out.println();
        }
        CUL_WEIGHT_TUPLE.culValue(totalWeight, CUL_WEIGHT_TUPLE);
        CUL_WEIGHT_TUPLE.addValue(WEIGHT_TUPLE, CUL_WEIGHT_TUPLE);
        totalWeight = 0;
        return serverIp;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 50; i++) {
            getServerIp(i);
        }
    }
}
