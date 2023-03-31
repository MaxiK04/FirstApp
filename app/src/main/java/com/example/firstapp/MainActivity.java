package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    /**
     * Обработчик регистрации
     * @param view
     */
//    public void onSignUp(View view)
//    {
//        // выводим сообщение
//        EditText inputPass = findViewById(R.id.InputPass);
//        String emailText = String.valueOf(inputPass.getText());
//        Log.d("MainActivity", "onSignIn: " + emailText);
//    }

    public void onSignIn (View view){
        EditText inputEmail = findViewById(R.id.InputEmail);
        EditText inputPass = findViewById(R.id.InputPass);
        String passText = String.valueOf(inputPass.getText());
        String emailText = String.valueOf(inputEmail.getText());
        Log.d("MainActivity", "onSignIn: \n " + emailText + "\n" + passText);
    }
    public void onSignUp(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
