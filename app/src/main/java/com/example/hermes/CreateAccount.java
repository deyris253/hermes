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

public class CreateAccount extends AppCompatActivity {

    private ImageButton vGoToLogin;
    private EditText vFirstName;
    private EditText vFullName;
    private EditText vEmail;
    private EditText vPhoneNumber;
    private EditText vPassword;
    private EditText vConfirmPassword;
    private Button vRegister;
    private FirebaseAuth vFirebaseAuth;

    private Button vHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        vGoToLogin = findViewById(R.id.goToLogin);

        vFullName = findViewById(R.id.fullName);
        vFirstName = findViewById(R.id.firstName);
        vEmail = findViewById(R.id.email);
        vPhoneNumber = findViewById(R.id.phoneNumber);
        vPassword = findViewById(R.id.passwordCreation);
        vConfirmPassword = findViewById(R.id.confirmPassword);
        vRegister = findViewById(R.id.register);
        vFirebaseAuth = FirebaseAuth.getInstance();

        vHomeButton = findViewById(R.id.returnHome);


        vGoToLogin.setOnClickListener(v -> startActivity(new Intent(getApplication(), Login.class)));

        vRegister.setOnClickListener(v -> {
            String sFullName = vFullName.getText().toString();
            String sFirstName = vFirstName.getText().toString();
            String sEmail = vEmail.getText().toString();
            String sPhoneNumber = vPhoneNumber.getText().toString();
            String sPassword = vPassword.getText().toString();
            String sConfirmPassword = vConfirmPassword.getText().toString();

            if (sFullName.isEmpty() && sFirstName.isEmpty() && sEmail.isEmpty() && sPhoneNumber.isEmpty() && sPassword.length() < 7 && sConfirmPassword.equals(sPassword)) {
                vFullName.setError("Veuillez indiquer votre nom.");
                vFirstName.setError("Veuillez indiquer votre prénom.");
                vEmail.setError("Veuillez indiquer votre email.");
                vPhoneNumber.setError("Veuillez indiquer votre numéro de téléphone.");
                vPassword.setError("Le mot de passe doit contenir au moins 7 caractères.");
                vConfirmPassword.setError("Les mots de passe indiqués sont diffèrents.");
            } else {
                startActivity(new Intent(getApplication(), Home.class));
            }
        });

        vHomeButton.setOnClickListener(v -> startActivity(new Intent(getApplication(), Login.class)));


    }
}