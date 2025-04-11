package com.example.checkbox; // 패키지명은 실제 프로젝트 이름에 맞게 수정하세요.

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxMeat, checkBoxCheese;
    private ImageView imageMeat, imageCheese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 체크박스 및 이미지 뷰 초기화
        checkBoxMeat = findViewById(R.id.checkBoxMeat);
        checkBoxCheese = findViewById(R.id.checkBoxCheese);

        imageMeat = findViewById(R.id.imageMeat);
        imageCheese = findViewById(R.id.imageCheese);
    }

    // 체크박스 클릭 시 호출되는 메서드
    public void onCheckboxClicked(View view) {
        int id = view.getId();

        if (id == R.id.checkBoxMeat) {
            imageMeat.setVisibility(checkBoxMeat.isChecked() ? View.VISIBLE : View.GONE);
        } else if (id == R.id.checkBoxCheese) {
            imageCheese.setVisibility(checkBoxCheese.isChecked() ? View.VISIBLE : View.GONE);
        }
    }

}
