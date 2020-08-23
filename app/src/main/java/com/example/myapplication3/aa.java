package com.example.myapplication3;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.example.myapplication3.bean.Person;

public class aa implements LifecycleObserver {

    private static final String TAG = "WorkUtil";

    private boolean whetherToCount = true;

    private int count = 0;

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void start() {
        whetherToCount=true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (whetherToCount) {
                    try {
                        Thread.sleep(1000);
                        count++;
                        Log.d(TAG, "start: " + count);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        whetherToCount = false;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestory() {
        count = 0;
    }


}
