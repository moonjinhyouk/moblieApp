package com.example.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class ToDoDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "todo.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "tasks";
    private static final String COL_TASK = "task";

    public ToDoDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 테이블 생성
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" + COL_TASK + " TEXT PRIMARY KEY)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // 할 일 추가
    public void insertTask(String task) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_TASK, task);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    // 할 일 삭제
    public void deleteTask(String task) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, COL_TASK + "=?", new String[]{task});
        db.close();
    }

    // 모든 할 일 불러오기
    public ArrayList<String> getAllTasks() {
        ArrayList<String> taskList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{COL_TASK}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            taskList.add(cursor.getString(0));
        }
        cursor.close();
        db.close();
        return taskList;
    }
}
