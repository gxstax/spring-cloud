package com.ant.hash;

import com.ant.ServerIps;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Ant
 * @ClassName: HashCircle
 * @Description: 利用hash算法的写一个hash环负载均衡算法
 * @datetime 2019/1/29 8:46
 * @Version 1.0
 */
public class HashCircle {

    private static Integer totalWeight;
    public static TreeMap<Integer, String> serverTreeMap = new TreeMap<>();

    static {
        totalWeight = ServerIps.WEIGHT_SERVER_LST.values().stream().reduce(0, (sum, item)-> sum += item);
    }

    public static void main(String[] args) {

        // 初始化服务TreeMap
        for (String server:ServerIps.SERVER_LST) {
            serverTreeMap.put(getHash(server), server);
            for (int i = 0; i < 2; i++) {
                String serverstr = server + "VN" + i;
                serverTreeMap.put(getHash(serverstr), serverstr);
            }
        }
        System.out.println(getClient("192.207.2.02"));
    }

    /**
     * 获取服务
     * @param client
     * @return
     */
    public static String getClient(String client) {
        int hash = getHash(client);

        SortedMap<Integer, String> subServerMap = serverTreeMap.tailMap(hash);

        return strTrans(subServerMap.get(subServerMap.firstKey()));
    }

    /**
     * 简单hash算法实现
     * @param str
     * @return
     */
    public static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
            hash += hash << 13;
            hash ^= hash << 7;
            hash += hash << 11;
            hash ^= hash << 17;
            hash += hash << 5;
        }
        // 如果算出来的hash值是负数，则取其绝对值
        if(hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }

    /**
     * 服务名称转换
     * @param str
     * @return
     */
    public static String strTrans(String str) {
        if (str.contains("VN")) {
            return str.substring(0, str.indexOf("V"));
        }
        return str;
    }
}
