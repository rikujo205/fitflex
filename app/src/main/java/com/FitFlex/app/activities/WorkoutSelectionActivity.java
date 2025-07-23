package com.FitFlex.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.FitFlex.app.R;

public class WorkoutSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_selection);
    }

    public void openUpperBodyWorkout(View view) {
        Intent intent = new Intent(this, UpperBodyWorkoutActivity.class);
        startActivity(intent);
    }

    public void openBackWorkout(View view) {
        Intent intent = new Intent(this, BackWorkoutActivity.class);
        startActivity(intent);
    }

    public void openCoreWorkout(View view) {
        Intent intent = new Intent(this, CoreWorkoutActivity.class);
        startActivity(intent);
    }

    public void openLowerBodyWorkout(View view) {
        Intent intent = new Intent(this, LowerBodyWorkoutActivity.class);
        startActivity(intent);
    }
}