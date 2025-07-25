package com.FitFlex.app.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.FitFlex.app.R;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class BackWorkoutActivity extends AppCompatActivity {

    private CheckBox checkbox1, checkbox2, checkbox3, checkbox4;
    private Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Use the correct layout name here!
        setContentView(R.layout.activity_back_workout);

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
                Intent intent = new Intent(BackWorkoutActivity.this, WorkoutSelectionActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // optional: clears back stack
                startActivity(intent);
                finish(); // optional: closes current activity
            }
        });
    }

    private void checkAllCheckboxes() {
        boolean allChecked = checkbox1.isChecked() && checkbox2.isChecked() && checkbox3.isChecked() && checkbox4.isChecked();
        myButton.setEnabled(allChecked);
    }
}
