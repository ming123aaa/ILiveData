package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void start2(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }

    public void start1(View view) {
        startActivity(new Intent(this,MainActivity2.class));
    }

}