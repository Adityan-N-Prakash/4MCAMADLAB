package com.example.intentactivities;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER);

        TextView textView = new TextView(this);
        textView.setText("Welcome To The Second Activity");
        textView.setTextSize(40);
        textView.setTextColor(Color.BLACK);

        linearLayout.addView(textView);
        setContentView(linearLayout);
    }
}
