package com.example.siyehua.myanotation.custom;

import android.arch.lifecycle.LiveData;

/**
 * 自定义 LiveData
 */
public class MyLifeData<T> extends LiveData<T> {
    @Override
    public void postValue(T value) {
        super.postValue(value);
    }

    @Override
    public void setValue(T value) {
        super.setValue(value);
    }
}
