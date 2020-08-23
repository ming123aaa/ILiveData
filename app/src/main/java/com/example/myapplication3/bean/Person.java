package com.example.myapplication3.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Person  {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

   void nihao(){
        System.out.println("你好");
    }

    public int getId() {
        return id;
    }

    public String getIdToString(){
        return String.valueOf(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

}
