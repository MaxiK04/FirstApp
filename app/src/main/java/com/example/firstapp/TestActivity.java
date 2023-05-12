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
        private TextInputEditText edGender, edHeight,edWeight,edAge,edPress,edRunch,edRun, edJump,edSlant, edPullUp;
        private DatabaseReference testDbRef;
        private String TEST_REF = "Test";
        private String DB_HOST = "https://project-e1e65-default-rtdb.europe-west1.firebasedatabase.app";
        private static final String TAG = "TestActivity";
        private FirebaseAuth mAuth;


        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.test_activity);
            mAuth = FirebaseAuth.getInstance();
            testDbRef = FirebaseDatabase.getInstance(DB_HOST).getReference(TEST_REF);
            edit();
        }
        public void goToPsyhoTest(){
            Intent intent = new Intent(TestActivity.this, PsyhoTestActivity.class);
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

        }
        public void onClickSave(View view)
        {
            Test newTest = new Test();
            newTest.id = testDbRef.getKey();
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
            Log.w("Tests", "this weight" + newTest.weight);
            newTest.calc();
            if (newTest.isCorrect())
            {
                testDbRef.child(newTest.id).setValue(newTest)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.w("Tests", "setValue success");
                                goToPsyhoTest();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("Tests", "setValue failure");
                                Toast.makeText(TestActivity.this, "Не удалось сохранить текущий шаг /n Попробуйте позже", Toast.LENGTH_SHORT).show();
                            }
                        });;
            }
            else
            {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
                return;
            }

        }
        public void onClickRead(View view)
        {

        }

}
