package com.ant.util;

import java.util.Optional;

/**
 * @author Ant
 * @ClassName: AntTuple_3
 * @Description: 自定义数据结构
 * @datetime 2019/1/28 9:12
 * @Version 1.0
 */
public abstract class Tuple {

    public abstract <A> Optional<A> T1(A a);

    public abstract <B> Optional<B> T2(B b);

    public abstract <C> Optional<C> T3(C c);

    public static <A, B, C> Tuple of(A a, B b, C c) {
        return new AntTuple_3(a, b, c);
    }
}
