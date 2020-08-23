package com.example.myapplication3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication3.bean.Person;
import com.example.myapplication3.ui.main.MainFragment;

import java.lang.ref.WeakReference;
import java.net.Socket;

public class MainActivity2 extends AppCompatActivity {

    private Handler handler1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
       final Handler handler=new MyHandler(this);
        new Thread(new Runnable() {
            @SuppressLint("HandlerLeak")
            @Override
            public void run() {
                Looper.prepare();
                handler1 =new Handler(){
                    @Override
                    public void handleMessage(@NonNull Message msg) {
                        super.handleMessage(msg);
                        System.out.println((String) msg.obj);
                    }
                };
                Looper.loop();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    Message message=new Message();
                    message.obj="你好";
                    Message message1=new Message();
                    message1.obj="你好";
                    handler.sendMessage(message);
                    handler1.sendMessage(message1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();


    }



  public static class MyHandler extends Handler{
        private WeakReference<MainActivity2> weakReference;

        public MyHandler(MainActivity2 mainActivity2){
            weakReference=new WeakReference<>(mainActivity2);
        }

      @Override
      public void handleMessage(@NonNull Message msg) {
          super.handleMessage(msg);
           MainActivity2 mainActivity2= weakReference.get();
          Toast.makeText(mainActivity2,(String)msg.obj,Toast.LENGTH_SHORT).show();
      }
  }

    public void startaa(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }

    public void startaab(View view) {
        startActivity(new Intent(this,Main4Activity.class));


    }



}