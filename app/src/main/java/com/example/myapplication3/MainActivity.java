package com.example.myapplication3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication3.bean.Person;
import com.example.myapplication3.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
  private ViewModelProvider mModelWithLiveData;
    private ActivityMainBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("lifrcycle","onCreate");
        dataBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        Person person =new Person(200,"水王楼主");
        dataBinding.setPerson(person);
        dataBinding.setClick(new ClickBinding());//监听事件


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);



    }



    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("lifrcycle","onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("lifrcycle","onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("lifrcycle","onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("lifrcycle","onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("lifrcycle","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("lifrcycle","onStop");
    }


}