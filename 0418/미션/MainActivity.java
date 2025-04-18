// MainActivity.java
package com.example.mission;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private View colorBox;
    private TextView colorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 색상을 표시할 뷰와 텍스트뷰 초기화
        colorBox = findViewById(R.id.colorBox);
        colorName = findViewById(R.id.colorName);

        // 기본 색상 설정
        changeColor(Color.GRAY, "회색 (기본)");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 메뉴 인플레이트
        getMenuInflater().inflate(R.menu.color_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // 메뉴 아이템 선택 처리
        int itemId = item.getItemId();

        if (itemId == R.id.menu_red) {
            changeColor(Color.RED, "빨간색");
            showToast("빨간색 선택됨");
            return true;
        } else if (itemId == R.id.menu_green) {
            changeColor(Color.GREEN, "초록색");
            showToast("초록색 선택됨");
            return true;
        } else if (itemId == R.id.menu_blue) {
            changeColor(Color.BLUE, "파란색");
            showToast("파란색 선택됨");
            return true;
        } else if (itemId == R.id.menu_yellow) {
            changeColor(Color.YELLOW, "노란색");
            showToast("노란색 선택됨");
            return true;
        } else if (itemId == R.id.menu_purple) {
            changeColor(Color.rgb(128, 0, 128), "보라색");
            showToast("보라색 선택됨");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // 색상 변경 메소드
    private void changeColor(int color, String colorText) {
        colorBox.setBackgroundColor(color);
        colorName.setText(colorText);
    }

    // 토스트 메시지 표시 메소드
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}