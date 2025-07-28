package com.FitFlex.app.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.FitFlex.app.R;

import android.content.SharedPreferences;
import androidx.appcompat.widget.SwitchCompat;

public class SettingsActivity extends AppCompatActivity {

    private SwitchCompat switch1, switch2, switch3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        switch1 = findViewById(R.id.switchLevel1);
        switch2 = findViewById(R.id.switchLevel2);
        switch3 = findViewById(R.id.switchLevel3);

        SharedPreferences prefs = getSharedPreferences("FitFlexPrefs", MODE_PRIVATE);
        int level = prefs.getInt("workoutLevel", 1);
        switch1.setChecked(level == 1);
        switch2.setChecked(level == 2);
        switch3.setChecked(level == 3);

        View.OnClickListener levelClickListener = v -> {
            int selectedLevel = 1;
            if (v == switch1) selectedLevel = 1;
            else if (v == switch2) selectedLevel = 2;
            else if (v == switch3) selectedLevel = 3;

            switch1.setChecked(v == switch1);
            switch2.setChecked(v == switch2);
            switch3.setChecked(v == switch3);

            prefs.edit().putInt("workoutLevel", selectedLevel).apply();
        };

        switch1.setOnClickListener(levelClickListener);
        switch2.setOnClickListener(levelClickListener);
        switch3.setOnClickListener(levelClickListener);
    }
}