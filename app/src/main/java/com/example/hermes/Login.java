package com.example.hermes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private static final int RC_SIGN_IN = 7544;
    private EditText vEmail;
    private EditText vPassword;
    private Button vLoginButton;
    private FirebaseAuth vFirebaseAuth;

    private GoogleSignInClient vGoogleSignClient;

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

        findViewById(R.id.googleButton).setOnClickListener(this);


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        vGoogleSignClient = GoogleSignIn.getClient(this, gso);

        vGoogleSignClient.signOut();

        vCreateButton.setOnClickListener(v -> startActivity(new Intent(getApplication(), CreateAccount.class)));

        vPasswordForgottenButton.setOnClickListener(v -> startActivity(new Intent(getApplication(), PasswordForgotten.class)));

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.googleButton) {
            signIn();
        }
    }

    private void signIn() {
        Intent signInIntent = vGoogleSignClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
}
