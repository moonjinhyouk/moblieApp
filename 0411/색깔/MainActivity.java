package com.example.image; // ← 프로젝트에 맞게 패키지명 수정

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView clothingImageView;
    Button colorButton1, colorButton2, colorButton3, colorButton4, colorButton5;
    RelativeLayout mainLayout; // 👉 RelativeLayout을 제어하려고 변수 추가

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // View 연결
        clothingImageView = findViewById(R.id.clothingImageView);
        colorButton1 = findViewById(R.id.colorButton1);
        colorButton2 = findViewById(R.id.colorButton2);
        colorButton3 = findViewById(R.id.colorButton3);
        colorButton4 = findViewById(R.id.colorButton4);
        colorButton5 = findViewById(R.id.colorButton5);
        mainLayout = findViewById(R.id.mainLayout); // RelativeLayout 연결

        // 각 버튼 클릭 시 배경색 변경
        colorButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainLayout.setBackgroundColor(Color.RED);
            }
        });

        colorButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainLayout.setBackgroundColor(Color.GREEN);
            }
        });

        colorButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainLayout.setBackgroundColor(Color.BLUE);
            }
        });

        colorButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainLayout.setBackgroundColor(Color.YELLOW);
            }
        });

        colorButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainLayout.setBackgroundColor(Color.LTGRAY);
            }
        });
    }
}
