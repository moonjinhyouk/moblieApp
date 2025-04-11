package com.example.a0404;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String currentInput = "";
    private double operand1 = 0;
    private double operand2 = 0;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        // 숫자 버튼 처리
        setNumberButtonClickListener(R.id.button1, "1");
        setNumberButtonClickListener(R.id.button2, "2");
        setNumberButtonClickListener(R.id.button3, "3");
        setNumberButtonClickListener(R.id.button4, "4");
        setNumberButtonClickListener(R.id.button5, "5");
        setNumberButtonClickListener(R.id.button6, "6");
        setNumberButtonClickListener(R.id.button7, "7");
        setNumberButtonClickListener(R.id.button8, "8");
        setNumberButtonClickListener(R.id.button9, "9");
        setNumberButtonClickListener(R.id.button0, "0");

        // 연산자 버튼 처리
        setOperatorButtonClickListener(R.id.buttonAdd, "+");
        setOperatorButtonClickListener(R.id.buttonSubtract, "-");
        setOperatorButtonClickListener(R.id.buttonMultiply, "*");
        setOperatorButtonClickListener(R.id.buttonDivide, "/");

        // 결과 버튼 처리
        Button equalsButton = findViewById(R.id.buttonEquals);
        equalsButton.setOnClickListener(v -> {
            operand2 = Double.parseDouble(currentInput);
            double result = 0;
            switch (operator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    if (operand2 != 0) {
                        result = operand1 / operand2;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
            }
            display.setText(String.valueOf(result));
            operand1 = result;
            currentInput = "";
        });

        // C 버튼 처리 (초기화)
        Button clearButton = findViewById(R.id.buttonClear);
        clearButton.setOnClickListener(v -> {
            operand1 = 0;
            operand2 = 0;
            operator = "";
            currentInput = "";
            display.setText("0");
        });
    }

    private void setNumberButtonClickListener(int buttonId, String value) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            currentInput += value;
            display.setText(currentInput);
        });
    }

    private void setOperatorButtonClickListener(int buttonId, String operator) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            if (!currentInput.isEmpty()) {
                operand1 = Double.parseDouble(currentInput);
                currentInput = "";
                this.operator = operator;
            }
        });
    }
}
