package com.example.hermes;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class PasswordForgotten extends AppCompatActivity {

    private ImageButton vGoToLogin;

    private EditText vEmail;
    private Button vSendPasswordReset;
    private FirebaseAuth vFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_forgotten);

        vGoToLogin = findViewById(R.id.goToLogin);
        vEmail = findViewById(R.id.typeEmail);
        vSendPasswordReset = findViewById(R.id.passwordReset);
        vFirebaseAuth = FirebaseAuth.getInstance();


        vGoToLogin.setOnClickListener(v -> startActivity(new Intent(getApplication(), Login.class)));

        vSendPasswordReset.setOnClickListener(v -> {
            String sEmail = vEmail.getText().toString().trim();

            if (sEmail.isEmpty()) {
                vEmail.setError("Veuillez indiquer votre email.");
            }
        });


    }
}