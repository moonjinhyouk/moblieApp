package com.example.context;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.TextView01);
        registerForContextMenu(text);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("컨텍스트메뉴");
        menu.add(0, 1, 0, "배경색:RED");
        menu.add(0, 2, 0, "배경색:GREEN");  // 오타 수정
        menu.add(0, 3, 0, "배경색:BLUE");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == 1) {
            text.setBackgroundColor(Color.RED);
            return true;
        } else if (id == 2) {
            text.setBackgroundColor(Color.GREEN);
            return true;
        } else if (id == 3) {
            text.setBackgroundColor(Color.BLUE);
            return true;
        }
        return super.onContextItemSelected(item);
    }
}
