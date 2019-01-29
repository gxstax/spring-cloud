package com.ant.poll;

import com.ant.ServerIps;

/**
 * @author Ant
 * @ClassName: SimplePolling
 * @Description: 负载均衡简单的轮询算法
 * @datetime 2019/1/24 13:59
 * @Version 1.0
 */
public class SimplePolling {

    public static Integer pos = -1;
    public static boolean reverse = false;

    public static String getServerIp () {
        synchronized (pos) {
            if (!reverse && pos < 9) {
                pos++;
            } else {
                reverse = true;
                pos--;
            }
            if (pos < 1) {
                reverse = false;
            }
        }

        return ServerIps.SERVER_LST.get(pos);

    }


    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println(getServerIp());
        }
    }
}
