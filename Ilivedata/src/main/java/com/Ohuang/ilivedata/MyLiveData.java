package com.Ohuang.ilivedata;

import android.app.Activity;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.HashMap;


public class MyLiveData {

    private HashMap<String, MutableLiveData<Object>> map;


    private static MyLiveData myLiveData = null;

    private MyLiveData() {
        map = new HashMap<>();
    }

    public static MyLiveData getInstance() {
        if (myLiveData == null) {
            myLiveData = new MyLiveData();
        }
        return myLiveData;
    }


//    public MutableLiveData get(String key) {
//        MutableLiveData<Object> mutableLiveData = map.get(key);
//        if (mutableLiveData == null) {
//            mutableLiveData = new MutableLiveData<>();
//            map.put(key, mutableLiveData);
//            mutableLiveData = map.get(key);
//        }
//        return mutableLiveData;
//    }

    public synchronized <T> MutableLiveData<T> with(String key, Class<T> t) {

        if (!map.containsKey(key)) {
            map.put(key, (MutableLiveData<Object>) new MutableLiveData<T>());
        }else {
            if (map.get(key)==null){
                map.put(key, (MutableLiveData<Object>) new MutableLiveData<T>());
            }
        }

        return (MutableLiveData<T>) map.get(key);
    }


    public void clear(String key){
        map.put(key,null);
    }




}
