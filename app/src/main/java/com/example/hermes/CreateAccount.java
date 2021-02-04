package com.example.hermes;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class CreateAccount extends AppCompatActivity {

    private FirebaseAuth vFirebaseAuth;
    private EditText vFirstName;
    private EditText vFullName;
    private EditText vEmail;
    private EditText vPhoneNumber;
    private EditText vPassword;
    private EditText vConfirmPassword;

    private Button vRegister;
    private Button vHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        vFirebaseAuth = FirebaseAuth.getInstance();
        vFullName = findViewById(R.id.fullName);
        vFirstName = findViewById(R.id.firstName);
        vEmail = findViewById(R.id.email);
        vPhoneNumber = findViewById(R.id.phoneNumber);
        vPassword = findViewById(R.id.passwordCreation);
        vConfirmPassword = findViewById(R.id.confirmPassword);
        vRegister = findViewById(R.id.register);
        vHomeButton = findViewById(R.id.returnHome);

        vRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sFullName = vFullName.getText().toString().trim();
                String sFirstName = vFirstName.getText().toString().trim();
                String sEmail = vEmail.getText().toString().trim();
                String sPhoneNumber = vPhoneNumber.getText().toString().trim();
                String sPassword = vPassword.getText().toString().trim();
                String sConfirmPassword = vConfirmPassword.getText().toString().trim();

                if (TextUtils.isEmpty(sFullName)) {
                    vFullName.setError("Veuillez indiquer votre nom.");
                }

                if (TextUtils.isEmpty(sFirstName)) {
                    vFirstName.setError("Veuillez indiquer votre prénom.");
                }

                if (TextUtils.isEmpty(sEmail)) {
                    vEmail.setError("Veuillez indiquer votre email.");
                }

                if (TextUtils.isDigitsOnly(sPhoneNumber)) {
                    vPhoneNumber.setError("Veuillez indiquer votre numéro de téléphone.");
                }

                if (TextUtils.isEmpty(sPassword)) {
                    vPassword.setError("Veuillez indiquer un mot de passe.");
                }

                if (sPassword.length() < 7) {
                    vPassword.setError("Le mot de passe doit contenir au moins 7 caractères.");
                }

                if (sPassword.equals(sConfirmPassword)) {
                    vConfirmPassword.setError("Les mots de passe indiqués sont diffèrents.");
                }
            }
        });

        vHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Home.class));
            }
        });


    }
}