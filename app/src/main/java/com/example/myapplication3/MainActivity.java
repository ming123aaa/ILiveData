package com.example.myapplication3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.Ohuang.ilivedata.HandlerLiveData;
import com.Ohuang.ilivedata.MyLiveData;
import com.example.myapplication3.bean.Person;
import com.example.myapplication3.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
  private ViewModelProvider mModelWithLiveData;
    private ActivityMainBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        Person person =new Person(200,"github");
        dataBinding.setPerson(person);
        dataBinding.setClick(new ClickBinding());//监听事件

        //在子线程延时发送数据 这个请点击按钮跳到MainActivity2注意liveData与Handler的区别
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    Message message=new Message();
                    message.obj="大家好";
                    HandlerLiveData.getInstance().sendMsg("1",message);//使用HandlerLiveData发送数据

                    Thread.sleep(3000);
                    Message message2=new Message();
                    message2.obj="大家好";
                    handler.sendMessage(message2);//使用Handler发送数据
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //使用HandlerLiveData接收数据
        HandlerLiveData.getInstance().addListener("1", this, new HandlerLiveData.HandlerLiveDataListener() {
            @Override
            public void HandlerMsg(Message message) {
                Toast.makeText(MainActivity.this, "HandlerLiveData:"+(String) message.obj,Toast.LENGTH_SHORT).show();
            }
        });


        //使用MyLiveData接收数据并改变textView显示的值
        MyLiveData.getInstance().with("1",Person.class).observe(this, new Observer<Person>() {
            @Override
            public void onChanged(Person person) {
                dataBinding.setPerson(person);
            }
        });


    }


    @SuppressLint("HandlerLeak")
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Toast.makeText(MainActivity.this, "Handler:"+(String) msg.obj,Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

    }



    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }


}