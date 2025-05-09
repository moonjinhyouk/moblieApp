package com.example.morningspark;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class StatsActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "morning_spark_prefs";
    private static final String KEY_COMPLETIONS = "completed_count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setTextSize(20f);
        textView.setPadding(32, 64, 32, 32);

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int count = prefs.getInt(KEY_COMPLETIONS, 0);

        textView.setText("🌟 Total morning tasks added: " + count);
        setContentView(textView);
    }
}