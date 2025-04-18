package com.example.memo;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TimerActivity extends AppCompatActivity {
    private CountDownTimer timer;
    private boolean isRunning = false;
    private TextView timerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        timerTextView = findViewById(R.id.timerTextView);
        Button start = findViewById(R.id.startTimerButton);
        Button stop = findViewById(R.id.stopTimerButton);

        start.setOnClickListener(v -> {
            if (!isRunning) {
                startTimer();
            }
        });

        stop.setOnClickListener(v -> {
            if (isRunning && timer != null) {
                timer.cancel();
                isRunning = false;
                timerTextView.setText("00:00");
            }
        });
    }

    private void startTimer() {
        timer = new CountDownTimer(15000, 1000) {
            public void onTick(long millisUntilFinished) {
                int sec = (int) (millisUntilFinished / 1000);
                timerTextView.setText("00:" + String.format("%02d", sec));
            }

            public void onFinish() {
                timerTextView.setText("끝!");
                isRunning = false;
            }
        };
        timer.start();
        isRunning = true;
    }
}
