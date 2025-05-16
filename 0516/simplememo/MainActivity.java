package com.example.simplememo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNote;
    private Button btnSave, btnLoad, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNote = findViewById(R.id.editTextNote);
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        btnDelete = findViewById(R.id.btnDelete);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNote();
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFileList("load");
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFileList("delete");
            }
        });
    }

    private void saveNote() {
        String text = editTextNote.getText().toString();
        if (text.isEmpty()) {
            Toast.makeText(this, "메모를 입력하세요", Toast.LENGTH_SHORT).show();
            return;
        }

        String fileName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".txt";
        try {
            FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE);
            fos.write(text.getBytes());
            fos.close();

            editTextNote.setText(""); // ✅ 메모창 초기화
            Toast.makeText(this, "메모 저장 완료", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "새 메모를 입력하세요", Toast.LENGTH_SHORT).show(); // ✅ 안내 메시지

        } catch (Exception e) {
            Toast.makeText(this, "저장 실패: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void showFileList(String action) {
        File dir = getFilesDir();
        File[] files = dir.listFiles();

        if (files == null || files.length == 0) {
            Toast.makeText(this, "저장된 메모가 없습니다", Toast.LENGTH_SHORT).show();
            return;
        }

        String[] fileNames = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            fileNames[i] = files[i].getName();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("메모 선택");

        builder.setItems(fileNames, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String selectedFile = fileNames[which];

                if (action.equals("load")) {
                    loadNote(selectedFile);
                } else if (action.equals("delete")) {
                    deleteNote(selectedFile);
                }
            }
        });

        builder.show();
    }

    private void loadNote(String fileName) {
        try {
            FileInputStream fis = openFileInput(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }

            fis.close();
            editTextNote.setText(stringBuilder.toString().trim());
            Toast.makeText(this, "메모 불러오기 완료", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "불러오기 실패: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void deleteNote(String fileName) {
        File file = new File(getFilesDir(), fileName);
        if (file.exists()) {
            if (file.delete()) {
                Toast.makeText(this, "메모 삭제 완료", Toast.LENGTH_SHORT).show();
                editTextNote.setText("");
            } else {
                Toast.makeText(this, "삭제 실패", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
