package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ListTestActivity extends AppCompatActivity {
    private DatabaseReference testDbRef;
    private String TEST_REF = "Test";
    private String DB_HOST = "https://project-e1e65-default-rtdb.europe-west1.firebasedatabase.app";
    private FirebaseDatabase firebase;
    private FirebaseAuth mAuth;

    public void onStart() {
        super.onStart();
        mAuth = FirebaseAuth.getInstance();
        testDbRef = FirebaseDatabase.getInstance(DB_HOST).getReference(TEST_REF);
        String owner = "QsZ6ipkB4mPtp3ROzqgnBRyVEXx1";
        String t1 = "qwe";
        testDbRef.orderByChild("owner").equalTo(owner).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Test> tests = new ArrayList<>();
                for (DataSnapshot testSnapshot: dataSnapshot.getChildren()) {
                    Test test = testSnapshot.getValue(Test.class);
                    tests.add(test);
                }
                printTests(tests);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("ListTestActivity", "onCancelled", databaseError.toException());
                // ...
            }
        });
    }

    private void printTests(List<Test> tests) {
        // TODO add teset on viewport
        Log.w("ListTestActivity", tests.toString());
    }
}

