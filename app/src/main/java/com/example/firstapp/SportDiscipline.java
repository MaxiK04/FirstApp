package com.example.firstapp;

public class SportDiscipline {
    public double football, basketball, volleyball, box, swim, tennis, polo, regby, athletic, bicycling, fencing, wrestling;
    public SportDiscipline(){
        this.football = 0;
        this.basketball = 0;
        this.volleyball = 0;
        this.box = 0;
        this.swim = 0;
        this.tennis = 0;
        this.polo = 0;
        this.regby = 0;
        this.athletic = 0;
        this.bicycling = 0;
        this.fencing = 0;
        this.wrestling = 0;
    }
    public String getResult(){
        String res = "Футболл";
        if(this.football < this.basketball) {
            res = "Баскетболл";
        }
        return res;
    }
}
