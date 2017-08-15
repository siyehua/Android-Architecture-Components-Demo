package com.example.siyehua.myanotation.mvp;

import com.example.siyehua.myanotation.ExecutorServiceManager;

import java.util.concurrent.TimeUnit;

/**
 * Created by siyehua on 2017/8/11.
 */

public class PersonPresenter implements IPresenter {
    private IView iView;

    public PersonPresenter(IView iView) {
        this.iView = iView;
    }

    @Override
    public void getName() {
        ExecutorServiceManager.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (iView != null) {
                    iView.setName("siyehua");
                }
            }
        });
    }

    public void removeView() {
        iView = null;
    }
}
