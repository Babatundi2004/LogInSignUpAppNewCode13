package com.example.loginsignupapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText etEmail,etUsername,etPassword;
    private FirebaseServices fbs;
    private Utilities utils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etEmail= findViewById(R.id.editTextEmailSignup);
        etUsername = findViewById(R.id.editTextUsernameSignup);
        etPassword = findViewById(R.id.editTextPasswordSignup);
        fbs=FirebaseServices.getInstance();
        utils= Utilities.getInstance();

    }

    public void getStarted(View view) {

        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        String email = etEmail.getText().toString();


        if (username.trim().isEmpty() || password.trim().isEmpty()||email.trim().isEmpty())
        {
            Toast.makeText(SignUpActivity.this, "Username,Password or Email is empty!", Toast.LENGTH_SHORT).show();
            return;
        }

        fbs.getAuth().createUserWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            // TODO: commands if successful
                        } else {

                            // TODO: commands if failed
                            Toast.makeText(SignUpActivity.this, "Username or password is empty!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                });
        if(!utils.validateEmail(this,email)||!utils.validatePassword(this,password)||!utils.validateUsername(this,username))
            return;
    }
}