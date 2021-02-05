package com.example.hermes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private EditText vEmail;
    private EditText vPassword;
    private Button vLoginButton;
    private FirebaseAuth vFirebaseAuth;

    private Button vCreateButton;
    private Button vPasswordForgottenButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        vFirebaseAuth = FirebaseAuth.getInstance();
        vEmail = findViewById(R.id.typeEmail);
        vPassword = findViewById(R.id.typePassword);
        vLoginButton = findViewById(R.id.loginButton);
        vCreateButton = findViewById(R.id.createAccount);
        vPasswordForgottenButton = findViewById(R.id.passwordForgotten);


        vLoginButton.setOnClickListener(v -> {
            String sEmail = vEmail.getText().toString();
            String sPassword = vPassword.getText().toString();

            if ((sEmail.isEmpty() || sEmail.length() < 0) && (sPassword.isEmpty() || sPassword.length() < 7)) {
                vEmail.setError("Veuillez indiquer votre email.");
                vPassword.setError("Votre mot de passe doit contenir au moins 7 caractères.");

            } else {
                startActivity(new Intent(getApplication(), Home.class));
            }
        });

             /* vFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {

                 }
             }) */


        vCreateButton.setOnClickListener(v -> startActivity(new Intent(getApplication(), CreateAccount.class)));

        vPasswordForgottenButton.setOnClickListener(v -> startActivity(new Intent(getApplication(), PasswordForgotten.class)));

    }

}