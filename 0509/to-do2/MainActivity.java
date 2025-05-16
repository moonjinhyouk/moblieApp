package com.example.morningspark;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText taskInput;
    private Button dateBtn, timeBtn, addBtn;
    private TextView dateTimeDisplay;
    private RecyclerView recyclerView;
    private TodoAdapter adapter;
    private List<TodoItem> todoList;
    private Calendar calendar = Calendar.getInstance();
    private String selectedDate = "", selectedTime = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskInput = findViewById(R.id.taskInput);
        dateBtn = findViewById(R.id.dateBtn);
        timeBtn = findViewById(R.id.timeBtn);
        addBtn = findViewById(R.id.addBtn);
        dateTimeDisplay = findViewById(R.id.dateTimeDisplay);
        recyclerView = findViewById(R.id.recyclerView);

        todoList = new ArrayList<>();
        adapter = new TodoAdapter(todoList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        dateBtn.setOnClickListener(v -> {
            DatePickerDialog dp = new DatePickerDialog(this, (view, y, m, d) -> {
                selectedDate = y + "-" + (m+1) + "-" + d;
                updateDateTimeDisplay();
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            dp.show();
        });

        timeBtn.setOnClickListener(v -> {
            TimePickerDialog tp = new TimePickerDialog(this, (view, h, m) -> {
                selectedTime = String.format("%02d:%02d", h, m);
                updateDateTimeDisplay();
            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
            tp.show();
        });

        addBtn.setOnClickListener(v -> {
            String title = taskInput.getText().toString().trim();
            if (!title.isEmpty() && !selectedDate.isEmpty() && !selectedTime.isEmpty()) {
                todoList.add(new TodoItem(title, selectedDate + " " + selectedTime));
                adapter.notifyItemInserted(todoList.size() - 1);
                taskInput.setText("");
                selectedDate = "";
                selectedTime = "";
                dateTimeDisplay.setText("날짜와 시간 선택 안됨");
            } else {
                Toast.makeText(this, "할 일, 날짜, 시간을 모두 입력하세요", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateDateTimeDisplay() {
        dateTimeDisplay.setText("선택: " + selectedDate + " " + selectedTime);
    }
}
