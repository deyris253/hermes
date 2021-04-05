package com.example.hermes;

import android.os.Bundle;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;


public class MainActivity extends GoogleSignIn {

    private FirebaseAuth vAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vAuth = FirebaseAuth.getInstance();

        // findViewById(R.id.facebookButton).setOnClickListener(v -> LoginManager.getInstance().logInWithReadPermissions(this,Arrays.asList("public_profile", "user_friends")));

        findViewById(R.id.googleButton).setOnClickListener(this);
    }
}

