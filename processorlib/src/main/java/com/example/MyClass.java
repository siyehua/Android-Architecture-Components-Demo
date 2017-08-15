package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyClass {
    public static void main(String[] args) {
        Object o = new Object();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new WaitRunnable(o));
        executorService.execute(new NotifyRunnable(o));
    }
}
