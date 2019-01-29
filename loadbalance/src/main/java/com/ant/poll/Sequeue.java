package com.ant.poll;

/**
 * @author Ant
 * @ClassName: Sequeue
 * @Description: 自增序列
 * @datetime 2019/1/25 8:42
 * @Version 1.0
 */
public class Sequeue {

    private static Integer queueNum = 0;

    public static Integer getAndIncrement() {
        return queueNum++;
    }
}
