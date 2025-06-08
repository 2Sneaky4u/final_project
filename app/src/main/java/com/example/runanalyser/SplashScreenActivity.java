package com.example.runanalyser;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ProgressBar pb = findViewById(R.id.progressBar);
        CountDownTimer countDownTimer = new CountDownTimer(2500, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                pb.setProgress(2500 - (int) millisUntilFinished);
                pb.setAlpha((float) (2500 - millisUntilFinished) / 2500);
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
            }
        };
        countDownTimer.start();
    }


}