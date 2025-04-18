package com.example.memo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ChecklistActivity extends AppCompatActivity {
    CheckBox checkBox1, checkBox2, checkBox3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        Button saveBtn = findViewById(R.id.saveChecklistButton);

        saveBtn.setOnClickListener(v -> {
            String result = "";
            if (checkBox1.isChecked()) result += "✔ 과제 1\n";
            if (checkBox2.isChecked()) result += "✔ 과제 2\n";
            if (checkBox3.isChecked()) result += "✔ 과제 3\n";

            Toast.makeText(this, result.isEmpty() ? "선택 없음" : result, Toast.LENGTH_SHORT).show();
        });
    }
}
