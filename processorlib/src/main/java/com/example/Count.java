package com.example;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 次数
 * Created by siyehua on 2017/8/8.
 */
public class Count {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private
//    volatile
    boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int add() {
        return atomicInteger.addAndGet(1);
    }

    public int get() {
        return atomicInteger.get();
    }
}
