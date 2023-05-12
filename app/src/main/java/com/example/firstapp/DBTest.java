package com.example.firstapp;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

;
public class DBTest {
    private DatabaseReference testDbRef;
    private String TEST_REF = "Test";
    private String DB_HOST = "https://project-e1e65-default-rtdb.europe-west1.firebasedatabase.app";
    public DBTest(){
        testDbRef = FirebaseDatabase.getInstance(DB_HOST).getReference(TEST_REF);
    }
    public void save(Test test, Context context, SaveTestListener listener){
        test.id = testDbRef.push().getKey();
        if (test.isCorrect())
            {
                testDbRef.child(test.id).setValue(test)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.w("Tests", "setValue success");
                                listener.onSuccess();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("Tests", "setValue failure");
                                Toast.makeText(context, "Не удалось сохранить", Toast.LENGTH_SHORT).show();
                                listener.onError();
                            }
                        });
            }
            else
            {
                Toast.makeText(context, "Заполните все поля", Toast.LENGTH_SHORT).show();
                listener.onError();
            }
    }
}
