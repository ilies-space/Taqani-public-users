package com.android.taqani.Login_SingUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.taqani.MainScreen;
import com.android.taqani.R;

public class Login_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
    }


    public void singUp(View view) {

        Intent myIntent = new Intent(this, SingUp_screen.class);
        this.startActivity(myIntent);

    }

    public void login(View view) {

        Intent myIntent = new Intent(this, MainScreen.class);
        this.startActivity(myIntent);
    }
}