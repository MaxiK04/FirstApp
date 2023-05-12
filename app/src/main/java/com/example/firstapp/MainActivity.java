package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private static final String TAG = "MainActivity";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
    }
//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser != null) {
//        }
//    }

    /**
     * Обработчик регистрации
     *
     * @param view
     */
//    public void onSignUp(View view)
//    {
//        // выводим сообщение
//        EditText inputPass = findViewById(R.id.InputPass);
//        String emailText = String.valueOf(inputPass.getText());
//        Log.d("MainActivity", "onSignIn: " + emailText);
//    }
    public void onSignIn(View view) {
        EditText inputEmail = findViewById(R.id.InputEmail);
        EditText inputPass = findViewById(R.id.InputPass);
        String passText = String.valueOf(inputPass.getText());
        String emailText = String.valueOf(inputEmail.getText());
        if (passText.isEmpty() || emailText.isEmpty()) {
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
            return;
        }

        Log.d("MainActivity", "onSignIn: \n " + emailText + "\n" + passText);
        signIn(emailText, passText);

    }
    public void onSignUp(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
    private void goToTestActivity(){
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
    }
    private void signIn(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            goToTestActivity();
//                updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Почта или пароль пользователя введены неверно", Toast.LENGTH_SHORT).show();
//                updateUI(null);
                        }
                    }
                });
    }
}

