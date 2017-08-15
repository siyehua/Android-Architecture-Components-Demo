package com.example.siyehua.myanotation.lifecycle;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.siyehua.myanotation.ExecutorServiceManager;

import java.util.concurrent.TimeUnit;

public class UserViewModel extends ViewModel {
    private String id = "";
    private LiveData<User> userLiveData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LiveData<User> getUserLiveData() {
        final MutableLiveData<User> data = new MutableLiveData<>();
        ExecutorServiceManager.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                User user = new User();
                user.setName("siyehua");
                user.setPassword("123456");
                Log.e("siyehua", "child thread...");
                data.postValue(user);

            }
        });

        return userLiveData = data;
    }

    public void setUserLiveData(LiveData<User> userLiveData) {
        this.userLiveData = userLiveData;
    }
}
