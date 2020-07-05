package com.android.taqani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.taqani.Login_SingUp.Login_screen;
import com.android.taqani.intro.IntroActivity;

public class UserType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);
    }

    public void user1(View view) {


        //open main activity

        Intent mainActivity = new Intent(getApplicationContext(), IntroActivity.class);
        startActivity(mainActivity);
        finish();

    }



    public void user2(View view) {


        //open main activity

        Intent mainActivity = new Intent(getApplicationContext(), IntroActivity.class);
        startActivity(mainActivity);
        finish();

    }
}