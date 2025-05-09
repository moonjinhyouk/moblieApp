package com.example.morningspark;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private EditText editRoutine;
    private Button btnAdd, btnAlarm, btnStats;
    private ListView listTasks;
    private ArrayList<String> taskList;
    private ArrayAdapter<String> adapter;

    private SharedPreferences prefs;
    private static final String PREFS_NAME = "morning_spark_prefs";
    private static final String KEY_TASKS = "tasks";
    private static final String KEY_COMPLETIONS = "completed_count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editRoutine = findViewById(R.id.editRoutine);
        btnAdd = findViewById(R.id.btnAdd);
        btnAlarm = findViewById(R.id.btnAlarm);
        btnStats = findViewById(R.id.btnStats);
        listTasks = findViewById(R.id.listTasks);

        prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        taskList = new ArrayList<>(loadTasks());

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        listTasks.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = editRoutine.getText().toString().trim();
                if (!task.isEmpty()) {
                    taskList.add(task);
                    adapter.notifyDataSetChanged();
                    saveTasks();
                    editRoutine.setText("");
                    incrementCompletionCount();
                }
            }
        });

        btnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNotification();
            }
        });

        btnStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // StatsActivity로 이동
                Intent intent = new Intent(MainActivity.this, com.example.morningspark.StatsActivity.class);
                startActivity(intent);
            }
        });
    }

    // 알림 설정: NotificationManager 사용
    private void setNotification() {
        // 알림을 표시하기 위해 NotificationManager 설정
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // 알림 채널을 설정 (API 26 이상에서 필요)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "morning_alarm_channel";
            CharSequence name = "Morning Alarm Channel";
            String description = "Channel for morning alarms";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channelId, name, importance);
            channel.setDescription(description);
            notificationManager.createNotificationChannel(channel);
        }

        // 알림 빌더 설정
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "morning_alarm_channel")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Morning Alarm")
                .setContentText("Good Morning! Time to start your day!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);

        // 알림 표시
        notificationManager.notify(0, builder.build());
        Toast.makeText(this, "Morning alarm set for 7:00 AM", Toast.LENGTH_SHORT).show();
    }

    // 태스크 저장
    private void saveTasks() {
        SharedPreferences.Editor editor = prefs.edit();
        Set<String> taskSet = new HashSet<>(taskList);
        editor.putStringSet(KEY_TASKS, taskSet);
        editor.apply();
    }

    // 태스크 로드
    private Set<String> loadTasks() {
        return prefs.getStringSet(KEY_TASKS, new HashSet<>());
    }

    // 완료 카운트 증가
    private void incrementCompletionCount() {
        int count = prefs.getInt(KEY_COMPLETIONS, 0);
        prefs.edit().putInt(KEY_COMPLETIONS, count + 1).apply();
    }
}
