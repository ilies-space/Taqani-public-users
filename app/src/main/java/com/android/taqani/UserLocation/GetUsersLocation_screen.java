package com.android.taqani.UserLocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.taqani.R;

public class GetUsersLocation_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users_location_screen);
    }

    public void showFullMap(View view) {

        //open main activity

        Intent mainActivity = new Intent(getApplicationContext(), GetUserLocationMap_screen.class);
        startActivity(mainActivity);
        finish();

    }
}