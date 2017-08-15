package com.example.siyehua.myanotation.custom;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

public class MyObserver implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void create() {
        Log.e("siyehua", "create");
        Throwable a = new Throwable();
        a.printStackTrace();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void stop() {
        Log.e("siyehua", "stop");
    }
}
