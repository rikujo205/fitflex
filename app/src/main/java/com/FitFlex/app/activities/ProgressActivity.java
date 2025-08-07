package com.FitFlex.app.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.FitFlex.app.R;

public class ProgressActivity extends AppCompatActivity {
    private TextView upperText, lowerText, backText, coreText;
    private ProgressBar upperProgressBar, lowerProgressBar, backProgressBar, coreProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        upperText = findViewById(R.id.upperProgressText);
        lowerText = findViewById(R.id.lowerProgressText);
        backText = findViewById(R.id.backProgressText);
        coreText = findViewById(R.id.coreProgressText);

        upperProgressBar = findViewById(R.id.upperProgressBar);
        lowerProgressBar = findViewById(R.id.lowerProgressBar);
        backProgressBar = findViewById(R.id.backProgressBar);
        coreProgressBar = findViewById(R.id.coreProgressBar);

        upperProgressBar.setMax(100);
        lowerProgressBar.setMax(100);
        backProgressBar.setMax(100);
        coreProgressBar.setMax(100);

        SharedPreferences prefs = getSharedPreferences("FitFlexPrefs", MODE_PRIVATE);

        int upperCount = prefs.getInt("upper_workout_count", 0);
        int lowerCount = prefs.getInt("lower_workout_count", 0);
        int backCount = prefs.getInt("back_workout_count", 0);
        int coreCount = prefs.getInt("core_workout_count", 0);

        upperProgressBar.setProgress(upperCount);
        lowerProgressBar.setProgress(lowerCount);
        backProgressBar.setProgress(backCount);
        coreProgressBar.setProgress(coreCount);

        upperText.setText("Upper Body Completed: " + upperCount + "/100 times");
        lowerText.setText("Lower Body Completed: " + lowerCount + "/100 times");
        backText.setText("Back Completed: " + backCount + "/100 times");
        coreText.setText("Core Completed: " + coreCount + "/100 times");
    }
}
