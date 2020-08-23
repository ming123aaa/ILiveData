package com.example.myapplication3;

import android.os.Message;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.HashMap;

public class HandlerLiveData {
    private static HandlerLiveData handlerLiveData = null;
    private HashMap<String, MutableLiveData<Message>> map;

    private HandlerLiveData() {
        map = new HashMap<>();

    }

    public static HandlerLiveData getInstance() {
        if (handlerLiveData == null) {
            handlerLiveData = new HandlerLiveData();
        }
        return handlerLiveData;
    }

    private MutableLiveData<Message> with(String key) {
        if (!map.containsKey(key)) {
            map.put(key, new MutableLiveData<Message>());
        }
        return map.get(key);
    }

    public void sendMsg(String key, Message message) {
        with(key).postValue(message);
    }


    private Message lsMessage = new Message();
    public void sendEmptyMessage(String key, int i) {
        lsMessage.what = i;
        with(key).postValue(lsMessage);
    }

    public void addListener(String key, LifecycleOwner lifecycleOwner, final HandlerLiveDataListener handlerLiveDataListener) {
        with(key).observe(lifecycleOwner, new Observer<Message>() {
            @Override
            public void onChanged(Message message) {
                handlerLiveDataListener.HandlerMsg(message);
            }
        });
    }


    interface HandlerLiveDataListener {
        void HandlerMsg(Message message);
    }
}
