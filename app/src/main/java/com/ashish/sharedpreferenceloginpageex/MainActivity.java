package com.ashish.sharedpreferenceloginpageex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                Boolean check = pref.getBoolean("Flag", false); // first it will try to get value from flag var and if unable then return default val (false here)
                Intent iNext;
                if(check){ // for true(User logged in)
                    iNext = new Intent(MainActivity.this, homeActivity.class);
                }else{ // for false(for first time or User logged out)
                    iNext = new Intent(MainActivity.this, LoginActivity.class);
                }
                startActivity(iNext);
            }
        }, 4000);
    }
}