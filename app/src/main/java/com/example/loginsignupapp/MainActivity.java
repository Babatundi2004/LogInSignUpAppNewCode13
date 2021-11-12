package com.example.loginsignupapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;   

public class
MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private FirebaseServices fbs;
    private Utilities utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.editTextEmailMain);
        etPassword = findViewById(R.id.editTextPasswordMain);
        fbs = FirebaseServices.getInstance();
        utils = Utilities.getInstance();

    }

    public void loginButton(View view) {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();


        if (username.trim().isEmpty() || password.trim().isEmpty()) {
            Toast.makeText(this, "Username or password is empty", Toast.LENGTH_LONG).show();
            return;
        }

        fbs.getAuth().signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            // TODO: commands if successful
                        } else {

                            // TODO: commands if failed
                            Toast.makeText(MainActivity.this, "Username or password is empty!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                });
        if (!utils.validatePassword(this, password) || !utils.validateUsername(this, username))
            return;
    }

    public void go_to_sign_up(View view) {
        Intent i = new Intent(this, SignUpActivity.class); // Intent is like a message in english , Intent to go to another page;
        startActivity(i);// powering the process;
    }

    public void gotoAddRest(View view) {
        Intent i = new Intent(this, AddRestActivity.class);
        startActivity(i);
    }

    public void gotoAllRests(View view) {
        Intent i = new Intent(this, AllRestActivity.class);
        startActivity(i);
    }
}





