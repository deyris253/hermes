package com.example.hermes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {

    private FirebaseAuth vFirebaseAuth;
    private EditText vEmail;
    private EditText vPassword;
    private Button vLoginButton;

    private TextView vCreateButton;
    private TextView vPasswordForgottenButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        vFirebaseAuth = FirebaseAuth.getInstance();
        vEmail = findViewById(R.id.email);
        vPassword = findViewById(R.id.password);
        vLoginButton = findViewById(R.id.loginButton);
        vCreateButton = findViewById(R.id.createAccount);
        vPasswordForgottenButton = findViewById(R.id.passwordForgotten);


        vLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = vEmail.getText().toString().trim();
                String password = vPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)) {
                    vEmail.setError("Error !");
                }

                if(TextUtils.isEmpty(password)) {
                    vEmail.setError("Your password is required.");
                }

                if(password.length()<6) {
                    vPassword.setError("Your password must contain at least 6 characters.");
                }


             /* vFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {

                 }
             }) */

                vCreateButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), CreateAccount.class));
                    }
                });

                vPasswordForgottenButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), PasswordForgotten.class));
                    }
                });
            }
        });

    }

}