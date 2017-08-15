package com.example.siyehua.myanotation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.siyehua.myanotation.mvp.Main3Activity;

public class MainActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void click(View view) {
        //mvp
        startActivity(new Intent(this, Main3Activity.class));

        //use
//        startActivity(new Intent(this, Main2Activity.class));

        //原理剖析
//        startActivity(new Intent(this, Main2Activity.class));


    }
}
