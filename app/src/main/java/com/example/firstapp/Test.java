package com.example.firstapp;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public String id, weight, age, height, owner, runch, run, press, gender, jump, pullup, slant, result;

    private SportDiscipline sportDiscipline;

    public Test() {
        this.sportDiscipline = new SportDiscipline();
    }
    public Test(String id, String weight, String age, String height, String owner,String runch, String run, String press, String gender, String jump, String pullup, String slant) {
        this.id = id;
        this.weight = weight;
        this.age = age;
        this.height = height;
        this.owner = owner;
        this.runch = runch;
        this.run = run;
        this.press = press;
        this.gender = gender;
        this.jump = jump;
        this.pullup = pullup;
        this.slant = slant;
        this.sportDiscipline = new SportDiscipline();
    }

    public boolean isCorrect() {
        return !TextUtils.isEmpty(this.age)
                && !TextUtils.isEmpty(this.weight)
                && !TextUtils.isEmpty(this.height)
                && !TextUtils.isEmpty(this.runch)
                && !TextUtils.isEmpty(this.run)
                && !TextUtils.isEmpty(this.press);
    }
    public void calc() {
        this.setWeightIndex();
        this.result = this.sportDiscipline.getResult();
    }
    private void setWeightIndex(){
        Integer weight = Integer.parseInt(this.weight);
        if (weight > 90) {
            this.sportDiscipline.football -= 1;
        }
    }
}
