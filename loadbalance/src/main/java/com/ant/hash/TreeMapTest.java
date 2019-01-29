package com.ant.hash;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Ant
 * @ClassName: TreeMapTest
 * @Description: treeMap 测试
 * @datetime 2019/1/29 8:47
 * @Version 1.0
 */
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap();

        treeMap.put("1", 1);
        treeMap.put("2", 2);
        treeMap.put("3", 3);
        treeMap.put("4", 4);
        treeMap.put("5", 5);
        treeMap.put("6", 6);
        treeMap.put("7", 7);

        SortedMap<String, Integer> subSortMap = treeMap.tailMap("4");

        System.out.println(subSortMap);

    }
}
