package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private String currentInput = "";
    private TextView display;
    String operator = "";
    Double operand1;

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
        updateDisplay();
    }

    public void onNumberClick(View view){
        currentInput += view.getTag().toString();
        updateDisplay();
    }

    public void onOperatorClick(View view){
        if(!currentInput.isEmpty()){
            operand1 = Double.parseDouble(currentInput);
            operator = view.getTag().toString();
            currentInput = "";
            updateDisplay();
        }
    }

    public void onEqualClick(View view){
        if(!currentInput.isEmpty() && !operator.isEmpty()){
            Double operand2 = Double.parseDouble(currentInput);
            Double result = performOperation(operand1, operand2, operator);
            currentInput = String.valueOf(result);
            operator = "";
            updateDisplay();
        }
    }

    public void onClearClick(View view){
        currentInput = "";
        operator = "";
        operand1 = 0.0;
        updateDisplay();
    }

    public Double performOperation(Double operand1, Double operand2, String operator){
        switch(operator) {
            case "+" : return operand1 + operand2;
            case "-" : return operand1 - operand2;
            case "*" : return operand1 * operand2;
            case "/" : {
                if(operand2 != 0){
                    return operand1 / operand2;
                } else {
                    return Double.NaN;
                }
            }
            default: return 0.0;
        }
    }

    public void updateDisplay(){
        if(display != null){
            display.setText(currentInput.isEmpty() ? "0" : currentInput);
        }
    }
}