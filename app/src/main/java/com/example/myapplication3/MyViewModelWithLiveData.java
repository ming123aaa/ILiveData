package com.example.myapplication3;

import android.app.Activity;
import android.database.DatabaseUtils;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication3.databinding.ActivityMainBinding;

public class MyViewModelWithLiveData extends ViewModel {
    // 数据
    private MutableLiveData<Integer> likeNumber;



    public MutableLiveData<Integer> getLikeNumber() {
        if (likeNumber == null){
            likeNumber = new MutableLiveData<>();
            likeNumber.setValue(0);
        }
        return likeNumber;
    }

    public void addLikeNumber(int add){
        likeNumber.setValue(likeNumber.getValue()+add);
    }

}
