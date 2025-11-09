package com.example.logindirectwelcome;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class welcomeactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitywelcome);

        TextView display = findViewById(R.id.display);
        String username = getIntent().getStringExtra("username");

        if (display != null) {
            if (username != null && !username.isEmpty()) {
                display.setText("Welcome, " + username + "!");
            } else {
                 display.setText("Welcome!");
            }
        } else {
            Log.e("welcomeactivity", "Fatal Error: TextView with ID 'display' not found in layout 'activitywelcome.xml'.");
            Toast.makeText(this, "Error: UI component missing.", Toast.LENGTH_LONG).show();
        }
    }
}
