package com.example.todolist;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextTask;
    Button btnAdd;
    ListView listViewTasks;
    ArrayAdapter<String> adapter;
    ArrayList<String> taskList;
    ToDoDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTask = findViewById(R.id.editTextTask);
        btnAdd = findViewById(R.id.btnAdd);
        listViewTasks = findViewById(R.id.listViewTasks);

        dbHelper = new ToDoDBHelper(this);
        taskList = dbHelper.getAllTasks();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        listViewTasks.setAdapter(adapter);

        // 할 일 추가 버튼 클릭 처리
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String task = editTextTask.getText().toString().trim();
                if (!task.isEmpty()) {
                    dbHelper.insertTask(task);
                    taskList.clear();
                    taskList.addAll(dbHelper.getAllTasks());
                    adapter.notifyDataSetChanged();
                    editTextTask.setText(""); // 입력란 초기화
                    Toast.makeText(MainActivity.this, "할 일이 추가되었습니다", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "할 일을 입력하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 할 일 항목 클릭 처리 (삭제)
        listViewTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedTask = taskList.get(position);

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("삭제 확인")
                        .setMessage("이 할 일을 삭제하시겠습니까?\n\n" + selectedTask)
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dbHelper.deleteTask(selectedTask);
                                taskList.clear();
                                taskList.addAll(dbHelper.getAllTasks());
                                adapter.notifyDataSetChanged();
                                Toast.makeText(MainActivity.this, "삭제 완료", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();
            }
        });
    }
}
