package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class TestActivity extends AppCompatActivity {
    private static final String[] Gender = new String[]{
            "Мужской","Женский"
    };
        private TextInputEditText edGender, edHeight,edWeight,edAge,edPress,edRunch,edRun, edJump,edSlant, edPullUp, edJumpUp, edRunlong;
        private static final String TAG = "TestActivity";
        private FirebaseAuth mAuth;


        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.test_activity);
            mAuth = FirebaseAuth.getInstance();
            edit();
        }
        public void goToPsyhoTest(Test test){
            Intent intent = new Intent(TestActivity.this, PsyhoTestActivity.class);
            intent.putExtra("Test", test);
            startActivity(intent);
        }
        public void edit()
        {
            edGender = findViewById(R.id.edGender);
            edAge = findViewById(R.id.edAge);
            edHeight = findViewById(R.id.edHeight);
            edWeight = findViewById(R.id.edWeight);
            edRunch = findViewById(R.id.edRunCh);
            edRun = findViewById(R.id.edRun);
            edPress = findViewById(R.id.edPress);
            edJump = findViewById(R.id.edJump);
            edSlant = findViewById(R.id.edSlant);
            edPullUp = findViewById(R.id.edPullUp);
            edJumpUp = findViewById(R.id.edJumpUp);
            edRunlong = findViewById(R.id.edRunLong);

        }
        public void onClickSave(View view)
        {
            Test newTest = new Test();
            newTest.gender = edGender.getText().toString();
            newTest.height = edHeight.getText().toString();
            newTest.weight = edWeight.getText().toString();
            newTest.age = edAge.getText().toString();
            newTest.owner = mAuth.getCurrentUser().getUid();
            newTest.runch = edRunch.getText().toString();
            newTest.run = edRun.getText().toString();
            newTest.press = edPress.getText().toString();
            newTest.jump = edJump.getText().toString();
            newTest.pullup = edPullUp.getText().toString();
            newTest.slant = edSlant.getText().toString();
            newTest.jumpup = edJumpUp.getText().toString();
            newTest.runlong = edRunlong.getText().toString();
            goToPsyhoTest(newTest);
//
//            newTest.calc();


        }
        public void onClickRead(View view)
        {

        }

}
