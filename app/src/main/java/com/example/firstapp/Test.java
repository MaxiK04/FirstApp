package com.example.firstapp;

import android.text.TextUtils;

public class Test {
    public String id, weight, age, height;

    public Test(String id, String weight, String age, String height) {
        this.id = id;
        this.weight = weight;
        this.age = age;
        this.height = height;
    }

    public boolean isCorrect() {
        return !TextUtils.isEmpty(this.age) && !TextUtils.isEmpty(this.weight) && !TextUtils.isEmpty(this.height);
    }
}
