package com.example.activitylifecycle;

import android.os.Bundle;
import android.util.Log;
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

        showToast("onCreate Called!");
        Log.d("MainActivity", "onCreate Called!");
    }

    @Override
    protected void onStart() {
        super.onStart();
        showToast("onStart Called!");
        Log.d("MainActivity", "onStart Called!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showToast("OnStop Called!");
        Log.d("MainActivity", "OnStop Called!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showToast("onPause Called!");
        Log.d("MainActivity", "onPause Called!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showToast("onRestart Called!");
        Log.d("MainActivity", "onRestart Called!");

    }

    @Override
    protected void onResume() {
        super.onResume();
        showToast("onResume Called!");
        Log.d("MainActivity", "onResume Called!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestroy Called!");
        Log.d("MainActivity", "onDestroy Called!");
    }

    public void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}