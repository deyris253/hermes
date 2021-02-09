package com.example.hermes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import java.util.Arrays;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText vEmail;
    private EditText vPassword;
    private TextView vLoginChoice;
    private FirebaseAuth vFirebaseAuth;

    CallbackManager callbackManager;

    private static final int RC_SIGN_IN = 7544;

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
        vLoginChoice = findViewById(R.id.loginChoice);
        vCreateButton = findViewById(R.id.createAccount);
        vPasswordForgottenButton = findViewById(R.id.passwordForgotten);


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

        vCreateButton.setOnClickListener(v -> startActivity(new Intent(getApplication(), CreateAccount.class)));

        vPasswordForgottenButton.setOnClickListener(v -> startActivity(new Intent(getApplication(), PasswordForgotten.class)));

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
