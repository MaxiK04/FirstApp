package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PsyhoTestActivity extends AppCompatActivity {

    Test test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.psyhotest_activity);

        Bundle arguments = getIntent().getExtras();

        if (arguments != null) {
            this.test = (Test) arguments.getSerializable("Test");
        }

    }

    public void onClickSave(View view){
        this.test.walkcount = "1";

        Log.w("psyhotest_activity", this.test.weight);
        this.test.calc();
        DBTest dbTest = new DBTest();
        dbTest.save(this.test, this, new SaveTestListener() {
            @Override
            public void onSuccess() {
                goToResultActivity();
            }
            @Override
            public void onError() {
            }
        });
    }
    public void goToResultActivity(){
        Intent intent = new Intent(PsyhoTestActivity.this, ResultActivity.class);
        intent.putExtra("result", this.test.result);
        startActivity(intent);
    }



}
