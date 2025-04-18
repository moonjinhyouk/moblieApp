package com.example.memo;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class QuoteActivity extends AppCompatActivity {
    String[] quotes = {
            "오늘도 수고했어요!",
            "작은 습관이 큰 변화를 만든다.",
            "꾸준함은 배신하지 않는다."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        TextView quoteTextView = findViewById(R.id.quoteTextView);
        int index = new Random().nextInt(quotes.length);
        quoteTextView.setText(quotes[index]);
    }
}
