package com.example.hermes;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PasswordForgotten extends AppCompatActivity {

    private EditText vEmail;
    private Button vSendPasswordReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_forgotten);

        vEmail = findViewById(R.id.typeEmail);
        vSendPasswordReset = findViewById(R.id.passwordReset);

        vSendPasswordReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sEmail = vEmail.getText().toString().trim();

                if (TextUtils.isEmpty(sEmail)) {
                    vEmail.setError("Veuillez indiquer votre email.");
                }
            }
        });


    }
}