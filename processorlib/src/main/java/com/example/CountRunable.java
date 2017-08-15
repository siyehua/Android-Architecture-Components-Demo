package com.example;

import java.util.concurrent.TimeUnit;

/**
 * 新增
 * Created by siyehua on 2017/8/8.
 */
public class CountRunable implements Runnable {
    private Count count;

    public CountRunable(Count count) {
        this.count = count;
    }

    public void stop() {
        count.setFlag(false);
        System.out.println("stop !  name: " + Thread.currentThread().getName() + count.add());
    }


    @Override
    public void run() {
        while (count.isFlag()) {
            try {
                System.out.println("name: " + Thread.currentThread().getName()
                        + " count: " + count.add());
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
