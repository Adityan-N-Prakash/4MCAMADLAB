package com.example.uicontrols;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button constraintButton = findViewById(R.id.constraint);
        Button linearButton = findViewById(R.id.linear);
        Button relativeButton = findViewById(R.id.relative);
        Button gridButton = findViewById(R.id.grid);
        Button frameButton = findViewById(R.id.frame);
        Button tableButton = findViewById(R.id.table);

        View.OnClickListener buttonClickListener = v ->{
            String layoutName = ((Button)v).getText().toString();
            displayToken(layoutName);
        };

        constraintButton.setOnClickListener(buttonClickListener);
        linearButton.setOnClickListener(buttonClickListener);
        relativeButton.setOnClickListener(buttonClickListener);
        gridButton.setOnClickListener(buttonClickListener);
        frameButton.setOnClickListener(buttonClickListener);
        tableButton.setOnClickListener(buttonClickListener);
    }

    public void displayToken(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}