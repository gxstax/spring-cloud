package com.ant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ant
 * @ClassName: ServerIps
 * @Description: 服务端Ip
 * @datetime 2019/1/23 8:55
 * @Version 1.0
 */
public class ServerIps {

    public static List<String> SERVER_LST = new ArrayList<>();
    public static Map<String, Integer>  WEIGHT_SERVER_LST = new HashMap<>();

    static {
        SERVER_LST.add("192.168.2.01");
        SERVER_LST.add("192.168.2.02");
        SERVER_LST.add("192.168.2.03");
        SERVER_LST.add("192.168.2.04");
        SERVER_LST.add("192.168.2.05");
        SERVER_LST.add("192.168.2.06");
        SERVER_LST.add("192.168.2.07");
        SERVER_LST.add("192.168.2.08");
        SERVER_LST.add("192.168.2.09");
        SERVER_LST.add("192.168.2.10");
    }

    // 权重 50
    static {
        WEIGHT_SERVER_LST.put("A", 5);
        WEIGHT_SERVER_LST.put("B", 1);
        WEIGHT_SERVER_LST.put("C", 1);
//        WEIGHT_SERVER_LST.put("192.168.2.04", 8);
//        WEIGHT_SERVER_LST.put("192.168.2.05", 3);
//        WEIGHT_SERVER_LST.put("192.168.2.06", 7);
//        WEIGHT_SERVER_LST.put("192.168.2.07", 4);
//        WEIGHT_SERVER_LST.put("192.168.2.08", 6);
//        WEIGHT_SERVER_LST.put("192.168.2.09", 5);
//        WEIGHT_SERVER_LST.put("192.168.2.10", 5);
    }

}
