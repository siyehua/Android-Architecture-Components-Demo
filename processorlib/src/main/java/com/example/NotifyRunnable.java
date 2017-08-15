package com.example;


import java.util.concurrent.TimeUnit;

public class NotifyRunnable implements Runnable {
    private final Object object;

    public NotifyRunnable(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " notify others.");
            object.notifyAll();
        }
    }
}
