package com.example.siyehua.myanotation.custom;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.siyehua.myanotation.R;
import com.example.siyehua.myanotation.lifecycle.User;
import com.example.siyehua.myanotation.lifecycle.UserViewModel;

/**
 * 本质
 */
public class Main2Activity extends AppCompatActivity implements LifecycleRegistryOwner {

    //LifecycleFragment 与 LifecycleActivity 实际上的实现
    final LifecycleRegistry mRegistry = new LifecycleRegistry(new LifecycleOwner() {
        @Override
        public Lifecycle getLifecycle() {
            return Main2Activity.this.getLifecycle();
        }
    });

    @Override
    public LifecycleRegistry getLifecycle() {
        return mRegistry;
    }

    private Button btButton;

    private UserViewModel userViewModel;
    private UserViewModel userViewModel2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btButton = (Button) findViewById(R.id.bt_click);

        ViewModelProvider viewModelProvider = ViewModelProviders.of(this);
        userViewModel = viewModelProvider.get(UserViewModel.class);
        userViewModel.getUserLiveData().observe(this, new Observer<User>() {
            @Override
           public void onChanged(@Nullable User user) {
                Throwable a = new Throwable();
                a.printStackTrace();
                if (user != null) {
                    Log.e("siyehua2", "update...");
                    btButton.setText(user.getName());
                }
            }
        });
        ViewModelProvider viewModelProvider2 = ViewModelProviders.of(this);

        userViewModel2 = viewModelProvider2.get(UserViewModel.class);
        //同一个 Activity 的 ViewModel 会被复用
        Log.e("siyehua", userViewModel.toString());
//        Log.e("siyehua", userViewModel2.toString());
//        Log.e("siyehua", viewModelProvider.toString());
//        Log.e("siyehua", viewModelProvider2.toString());
    }


    public void click(View view) {
        startActivity(new Intent(this, Main2Activity.class));
    }
}
