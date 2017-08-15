package com.example;

public class WaitRunnable implements Runnable {
    private final Object object;

    public WaitRunnable(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object) {
            try {
                System.out.println(Thread.currentThread().getName() + " wait.");
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " was notify.");
        }
    }
}
