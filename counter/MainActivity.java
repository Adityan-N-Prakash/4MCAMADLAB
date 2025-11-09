package com.example.counter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private int counter = 0;

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

        display = findViewById(R.id.display);
        Button incrementButton = findViewById(R.id.increment);
        Button decrementButton = findViewById(R.id.decrement);
        Button resetButton = findViewById(R.id.reset);

        incrementButton.setOnClickListener(v -> {
            counter++;
            updateDisplay();
        });

        decrementButton.setOnClickListener( v -> {
            counter--;
            updateDisplay();
        });

        resetButton.setOnClickListener( v -> {
            counter = 0;
            updateDisplay();
        });
    }

    public void updateDisplay(){
        if(display != null){
            display.setText(String.valueOf(counter));
        }
    }
}