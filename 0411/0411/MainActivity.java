package com.example.memo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMemo = findViewById(R.id.btnMemo);
        Button btnTimer = findViewById(R.id.btnTimer);
        Button btnQuote = findViewById(R.id.btnQuote);
        Button btnChecklist = findViewById(R.id.btnChecklist);

        btnMemo.setOnClickListener(v -> startActivity(new Intent(this, MemoActivity.class)));
        btnTimer.setOnClickListener(v -> startActivity(new Intent(this, TimerActivity.class)));
        btnQuote.setOnClickListener(v -> startActivity(new Intent(this, QuoteActivity.class)));
        btnChecklist.setOnClickListener(v -> startActivity(new Intent(this, ChecklistActivity.class)));
    }
}
