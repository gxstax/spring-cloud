package com.ant;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Ant
 * @ClassName: Test
 * @Description: 测试类
 * @datetime 2019/1/20 16:32
 * @Version 1.0
 */
public class Test {

    private static final ConcurrentMap<String, String> map = new ConcurrentHashMap<String, String>();

    public static void main(String[] args) {
        System.out.println(intern("s"));
    }

    public static String intern(String s) {
        String previousValue = map.putIfAbsent(s,s);
        return previousValue == null ? s : previousValue;
     }
}
