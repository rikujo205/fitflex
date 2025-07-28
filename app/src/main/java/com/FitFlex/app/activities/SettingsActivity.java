package com.FitFlex.app.activities;

//

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.FitFlex.app.utils.CalendarUtils;
import com.FitFlex.app.R;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void addReminder(View view) {
        String title = "Custom Workout";
        long reminderTime = System.currentTimeMillis() + 10 * 60 * 1000; // 10 mins from now
        CalendarUtils.addWorkoutReminder(this, title, reminderTime);

        Toast.makeText(this, "Workout reminder intent launched!", Toast.LENGTH_SHORT).show();
    }
}
