package com.example.hermes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

public class Login extends AppCompatActivity implements View.OnClickListener {

    CallbackManager callbackManager;

    private static final int RC_SIGN_IN = 7544;

    private GoogleSignInClient vGoogleSignClient;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        FirebaseAuth.getInstance();
        findViewById(R.id.loginChoice);

        callbackManager = CallbackManager.Factory.create();


        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        ImageButton fbButton = findViewById(R.id.facebookButton);

        fbButton.setOnClickListener(v -> LoginManager.getInstance().logInWithReadPermissions(this,
                Arrays.asList("public_profile", "user_friends")));



        findViewById(R.id.googleButton).setOnClickListener(this);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        vGoogleSignClient = GoogleSignIn.getClient(this, gso);

        vGoogleSignClient.signOut();

        findViewById(R.id.googleSignOut).setOnClickListener(v -> startActivity(new Intent(getApplication(), Login.class)));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
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
