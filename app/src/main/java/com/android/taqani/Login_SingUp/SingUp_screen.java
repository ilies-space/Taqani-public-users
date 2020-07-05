package com.android.taqani.Login_SingUp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.android.taqani.R;

public class SingUp_screen extends AppCompatActivity {
    //create a list of items for the spinner.
    ArrayAdapter< String > adapter0, adapter1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up_screen);

            final String[] items0, items1;

            // spinner :
            //Spinners
            //نوع الجوال
            Spinner dropdown0 = findViewById(R.id.spinner0);
            items0 = new String[] {
                    "المدينة",
                    "مثال 1",
                    "مثال 2",
                    "اخرى ... "
            };
            adapter0 = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, items0);
            adapter0.setDropDownViewResource(R.layout.spinner_item_dropdown);
            dropdown0.setAdapter(adapter0);


            //نوع الموديل
            Spinner dropdown1 = findViewById(R.id.spinner1);
            items1 = new String[] {
                    "المنطقة",
                    "مثال 1",
                    "مثال 2",
                    "اخرى ... "
            };
            adapter1 = new ArrayAdapter <String> (getApplicationContext(), R.layout.spinner_item, items1);
            adapter1.setDropDownViewResource(R.layout.spinner_item_dropdown);
            dropdown1.setAdapter(adapter1);
        }
    }
