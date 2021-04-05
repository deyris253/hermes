package com.example.hermes;

import android.os.Bundle;

import com.facebook.login.LoginManager;

public class MainActivity extends GoogleSignIn {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.googleButton).setOnClickListener(this);

        // findViewById(R.id.facebookButton).setOnClickListener(v -> LoginManager.getInstance().logInWithReadPermissions(this,Arrays.asList("public_profile", "user_friends")));
    }
}

