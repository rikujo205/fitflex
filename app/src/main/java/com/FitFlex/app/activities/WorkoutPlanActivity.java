package com.FitFlex.app.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.FitFlex.app.R;
import com.FitFlex.app.utils.CalendarUtils;
import com.FitFlex.app.utils.WorkoutPlanManager;

public class WorkoutPlanActivity extends AppCompatActivity {

    private EditText workoutInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_plan);
        workoutInput = findViewById(R.id.workoutInput);
    }

    public void saveWorkout(View view) {
        String workout = workoutInput.getText().toString();
        if (!workout.isEmpty()) {
            WorkoutPlanManager.saveWorkout(this, workout);
            Toast.makeText(this, "Workout Saved!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please enter a workout plan.", Toast.LENGTH_SHORT).show();
        }
    }

    public void addCalendarReminder(View view) {
        String title = "Workout Reminder";
        long reminderTime = System.currentTimeMillis() + 60000; // 1 minute from now
        CalendarUtils.addWorkoutReminder(this, title, reminderTime);
    }
}
