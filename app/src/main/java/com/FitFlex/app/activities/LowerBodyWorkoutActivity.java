package com.FitFlex.app.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.FitFlex.app.R;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.content.SharedPreferences;
import android.widget.LinearLayout;


public class LowerBodyWorkoutActivity extends AppCompatActivity {

    private CheckBox checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6, checkbox7, checkbox8;
    private Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Use the correct layout name here!
        setContentView(R.layout.activity_lower_body_workout);

        // Get references to UI elements
        checkbox1 = findViewById(R.id.checkbox1);
        checkbox2 = findViewById(R.id.checkbox2);
        checkbox3 = findViewById(R.id.checkbox3);
        checkbox4 = findViewById(R.id.checkbox4);
        myButton = findViewById(R.id.myButton);

        // Initially disable the button
        myButton.setEnabled(false);

        // Listener to monitor checkbox changes
        CompoundButton.OnCheckedChangeListener listener = (buttonView, isChecked) -> checkAllCheckboxes();

        checkbox1.setOnCheckedChangeListener(listener);
        checkbox2.setOnCheckedChangeListener(listener);
        checkbox3.setOnCheckedChangeListener(listener);
        checkbox4.setOnCheckedChangeListener(listener);

        Button finishButton = findViewById(R.id.myButton);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("FitFlexPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                int count = prefs.getInt("lower_workout_count", 0);
                editor.putInt("lower_workout_count", count + 1);
                editor.apply();

                Intent intent = new Intent(LowerBodyWorkoutActivity.this, WorkoutSelectionActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // optional: clears back stack
                startActivity(intent);
                finish(); // optional: closes current activity
            }
        });

        // Read selected level
        SharedPreferences prefs = getSharedPreferences("FitFlexPrefs", MODE_PRIVATE);
        int level = prefs.getInt("workoutLevel", 1);

        // Add checkboxes dynamically based on level
        LinearLayout layout = findViewById(R.id.workoutLayout); // You must add an ID to the LinearLayout in the XML

        if (level >= 2) {
            checkbox5 = new CheckBox(this);
            checkbox5.setText("4 Sets 1Min: Side Lunges (LEVEL 2)");
            checkbox5.setId(View.generateViewId());

            // Set padding (left, top, right, bottom) in pixels
            int padding = (int) getResources().getDisplayMetrics().density;
            checkbox5.setPadding(padding, padding, padding, padding);

            // Set top margin (just like xml: layout_marginTop="50dp")
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.topMargin = (int) (getResources().getDisplayMetrics().density * 50); // 50dp
            checkbox5.setLayoutParams(params);

            layout.addView(checkbox5);
            checkbox5.setOnCheckedChangeListener(listener);
        }

        if (level >= 2) {
            checkbox6 = new CheckBox(this);
            checkbox6.setText("4 Sets 10 Reps: Front Squat (LEVEL 2)");
            checkbox6.setId(View.generateViewId());

            // Set padding (left, top, right, bottom) in pixels
            int padding = (int) getResources().getDisplayMetrics().density;
            checkbox6.setPadding(padding, padding, padding, padding);

            // Set top margin (just like xml: layout_marginTop="50dp")
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.topMargin = (int) (getResources().getDisplayMetrics().density * 50); // 50dp
            checkbox6.setLayoutParams(params);

            layout.addView(checkbox6);
            checkbox6.setOnCheckedChangeListener(listener);
        }

        if (level == 3) {
            checkbox7 = new CheckBox(this);
            checkbox7.setText("4 sets 1Min: Wall Sits (LEVEL 3)");
            checkbox7.setId(View.generateViewId());

            int padding = (int) getResources().getDisplayMetrics().density;
            checkbox7.setPadding(padding, padding, padding, padding);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.topMargin = (int) (getResources().getDisplayMetrics().density * 50);
            checkbox7.setLayoutParams(params);

            layout.addView(checkbox7);
            checkbox7.setOnCheckedChangeListener(listener);
        }

        if (level == 3) {
            checkbox8 = new CheckBox(this);
            checkbox8.setText("4 Sets 10 Reps: Calf Raises (LEVEL 3)");
            checkbox8.setId(View.generateViewId());

            int padding = (int) getResources().getDisplayMetrics().density;
            checkbox8.setPadding(padding, padding, padding, padding);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.topMargin = (int) (getResources().getDisplayMetrics().density * 50);
            checkbox8.setLayoutParams(params);

            layout.addView(checkbox8);
            checkbox8.setOnCheckedChangeListener(listener);
        }
    }

    private void checkAllCheckboxes() {
        boolean allChecked = checkbox1.isChecked() && checkbox2.isChecked() && checkbox3.isChecked() && checkbox4.isChecked();

        if (checkbox5 != null) allChecked &= checkbox5.isChecked();
        if (checkbox6 != null) allChecked &= checkbox6.isChecked();

        myButton.setEnabled(allChecked);
    }

}