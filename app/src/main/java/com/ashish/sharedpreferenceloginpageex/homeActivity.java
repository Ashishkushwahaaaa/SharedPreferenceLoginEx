package com.ashish.sharedpreferenceloginpageex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class homeActivity extends AppCompatActivity {

    AppCompatButton btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("Flag", false);
                editor.apply();
                Toast.makeText(homeActivity.this, "LoggedOut Successfully", Toast.LENGTH_SHORT).show();
                Intent iLogin = new Intent(homeActivity.this, LoginActivity.class);
                iLogin.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(iLogin);
                finish();
            }
        });

    }
}