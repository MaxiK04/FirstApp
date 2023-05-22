package com.example.firstapp;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Test implements Serializable {
    public String id, walkcount, weight, age, height, owner, runch, run, press, gender, jump, pullup, slant, jumpup, runlong, result;

    public Test() {
    }
    public Test(String id, String weight, String age, String height, String owner,String runch, String run, String press, String gender, String jump, String pullup, String slant,String jumpup, String runlong) {
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
        this.jumpup = jumpup;
        this.runlong = runlong;
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
        SportDiscipline sportDiscipline = new SportDiscipline();
        this.setWeightIndex(sportDiscipline);
        this.result = sportDiscipline.getResult();
    }
    private void setWeightIndex(SportDiscipline sportDiscipline){
        Integer weight = Integer.parseInt(this.weight);
        if (weight > 90) {
            sportDiscipline.football -= 1;
        }
    }
}
