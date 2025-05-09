package com.example.sketchapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DrawingView drawingView;  // 그림 그리기 뷰
    private ImageButton btnBlack, btnRed, btnBlue, btnGreen, btnClear;
    private SeekBar seekBarWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI 요소 초기화
        drawingView = findViewById(R.id.drawing_view);
        btnBlack = findViewById(R.id.btn_black);
        btnRed = findViewById(R.id.btn_red);
        btnBlue = findViewById(R.id.btn_blue);
        btnGreen = findViewById(R.id.btn_green);
        btnClear = findViewById(R.id.btn_clear);
        seekBarWidth = findViewById(R.id.seekbar_width);

        // 기본 색상 설정 (검정색)
        drawingView.setBrushColor("#000000");

        // 버튼 배경 색상 설정
        btnBlack.setBackgroundColor(getResources().getColor(android.R.color.black));  // 검정색
        btnRed.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));  // 빨간색
        btnBlue.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));  // 파란색
        btnGreen.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));  // 초록색

        // 버튼 클릭 리스너 설정
        btnBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setBrushColor("#000000");  // 검정색으로 설정
            }
        });

        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setBrushColor("#FF0000");  // 빨간색으로 설정
            }
        });

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setBrushColor("#0000FF");  // 파란색으로 설정
            }
        });

        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.setBrushColor("#00FF00");  // 초록색으로 설정
            }
        });

        // 지우기 버튼 클릭 리스너
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.clearCanvas();  // 캔버스 지우기
            }
        });

        // 브러시 굵기 조절 리스너
        seekBarWidth.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                drawingView.setBrushWidth(progress);  // 브러시 굵기 설정
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
}
