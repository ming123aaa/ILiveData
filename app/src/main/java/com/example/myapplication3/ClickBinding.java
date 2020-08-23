package com.example.myapplication3;

import android.content.Intent;
import android.view.View;

public class ClickBinding {

    public void itemClick(View view) {
        Intent intent = new Intent(view.getContext(),MainActivity2.class);

        view.getContext().startActivity(intent);

    }
}

