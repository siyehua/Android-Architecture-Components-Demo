package com.example.siyehua.myanotation.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.siyehua.myanotation.R;

public class Main3Activity extends AppCompatActivity implements IView {
    private TextView textView;

    private PersonPresenter personPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textView = (TextView) findViewById(R.id.tv_content);
        personPresenter = new PersonPresenter(this);

        personPresenter.getName();
    }

    @Override
    public void setName(String name) {
        Log.e(Main3Activity.class.getSimpleName(), "setName(): " + this.getClass().getSimpleName());
        textView.setText(name);
    }

    @Override
    protected void onDestroy() {
        //不移除 View 有可能导致内存泄漏
//        personPresenter.removeView();
        super.onDestroy();
    }
}
