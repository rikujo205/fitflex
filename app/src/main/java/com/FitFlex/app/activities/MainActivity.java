package com.FitFlex.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.FitFlex.app.R;
import com.FitFlex.app.utils.SharedPrefManager;

public class MainActivity extends AppCompatActivity {

    TextView greetingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greetingText = findViewById(R.id.greetingText);

        // Get saved username
        String username = SharedPrefManager.getUsername(this);
        if (username != null && !username.isEmpty()) {
            greetingText.setText("Welcome, " + username + "!");
        } else {
            greetingText.setText("Welcome!");
        }
    }

    public void openWorkoutSelection(View view) {
        Intent intent = new Intent(this, WorkoutSelectionActivity.class);
        startActivity(intent);
    }

    public void openWorkoutPlan(View view) {
        Intent intent = new Intent(this, WorkoutPlanActivity.class);
        startActivity(intent);
    }

    public void openSuggestions(View view) {
        Intent intent = new Intent(this, SuggestionActivity.class);
        startActivity(intent);
    }

    public void openSettings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
