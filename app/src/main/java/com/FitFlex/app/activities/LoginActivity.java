package com.FitFlex.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.FitFlex.app.R;
import com.FitFlex.app.utils.SharedPrefManager;

public class LoginActivity extends AppCompatActivity {

    EditText usernameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameInput = findViewById(R.id.editTextUsername);
    }

    public void onLogin(View view) {
        String username = usernameInput.getText().toString().trim();

        if (username.isEmpty()) {
            Toast.makeText(this, "Please enter a username", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPrefManager.saveUsername(this, username);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish(); // Prevents back-navigation to login
    }
}
