package com.ant.util;

import java.util.Optional;

/**
 * @author Ant
 * @ClassName: AntTuple_3
 * @Description: 自定义数据结构
 * @datetime 2019/1/28 9:12
 * @Version 1.0
 */
public class AntTuple_3<A, B, C> extends Tuple{

    private A a;
    private B b;
    private C c;

    public AntTuple_3(){}

    public AntTuple_3(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public <A> Optional<A> T1(A a) {
        return (Optional<A>) Optional.empty().orElse(a);
    }

    @Override
    public <B> Optional<B> T2(B b) {
        return (Optional<B>) Optional.empty().orElse(b);
    }

    @Override
    public <C> Optional<C> T3(C c) {
        return (Optional<C>) Optional.empty().orElse(c);
    }

    /**
     * 整形的时候让最大值加上一个固定数值
     * @param value
     */
    public void culValue(int value, AntTuple_3 antTuple_3) {
        Integer aVal = (Integer) antTuple_3.getA();
        Integer bVal = (Integer) antTuple_3.getB();
        Integer cVal = (Integer) antTuple_3.getC();
        if(aVal >= bVal) {
            if(aVal >= cVal) {
                antTuple_3.setA(aVal - value);
            }else {
                antTuple_3.setC(cVal - value);
            }
        }else {
            if(bVal >= cVal) {
                antTuple_3.setB(bVal - value);
            }else {
                antTuple_3.setC(cVal - value);
            }
        }
    }

    public void addValue(AntTuple_3 initTuple, AntTuple_3 culTuple) {

        culTuple.setA((Integer)culTuple.getA() + (Integer)initTuple.getA());
        culTuple.setB((Integer)culTuple.getB() + (Integer)initTuple.getB());
        culTuple.setC((Integer)culTuple.getC() + (Integer)initTuple.getC());

    }


    public String getMaxValue(AntTuple_3 antTuple_3) {
        Integer aVal = (Integer) antTuple_3.getA();
        Integer bVal = (Integer) antTuple_3.getB();
        Integer cVal = (Integer) antTuple_3.getC();
        if(aVal >= bVal) {
            if(aVal >= cVal) {
                return "A";
            }else {
                return "C";
            }
        }else {
            if(bVal >= cVal) {
                return "B";
            }else {
                return "C";
            }
        }
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }
}
