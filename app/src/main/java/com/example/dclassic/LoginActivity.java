package com.example.dclassic;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {
    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        startBtn = findViewById(R.id.startBtn);

        startBtn.setOnClickListener(v -> {

            Intent intent =
                    new Intent(LoginActivity.this,
                            HomeActivity.class);

            startActivity(intent);

        });
    }
}