package com.app.flirtjar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityLogin extends AppCompatActivity implements FacebookCallback<LoginResult>
{

    @BindView(R.id.btn_fbLogin)
    LoginButton btnFbLogin;

    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        callbackManager = CallbackManager.Factory.create();

        btnFbLogin.setReadPermissions(Arrays.asList("email",
                "public_profile",
                "user_about_me",
                "user_birthday",
                "user_location",
                "user_photos",
                "user_relationships",
                "user_relationship_details",
                "user_relationship_details",
                "user_friends"));

        btnFbLogin.registerCallback(callbackManager, this);

    }

    @Override
    public void onSuccess(LoginResult loginResult)
    {
        //CREATE NEW USER ON SERVER USING API
        Toast.makeText(this, "LOGIN SUCCESSFUL " + loginResult.getAccessToken().getToken(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCancel()
    {
        Toast.makeText(this, "CANCELED", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(FacebookException error)
    {
        Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
