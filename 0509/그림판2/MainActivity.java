package com.example.anew;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private DrawingView drawingView;
    private int currentColor = Color.BLACK;
    private int currentThickness = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawingView = findViewById(R.id.drawingView);
        drawingView.setPaintColor(currentColor);
        drawingView.setStrokeWidth(currentThickness);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_clear) {
            drawingView.clearCanvas();
            return true;
        } else if (id == R.id.action_color) {
            showColorPickerDialog();
            return true;
        } else if (id == R.id.action_thickness) {
            showThicknessDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showColorPickerDialog() {
        final int[] colors = {
                Color.BLACK, Color.RED, Color.BLUE,
                Color.GREEN, Color.YELLOW, Color.MAGENTA
        };
        final String[] colorNames = {
                "Black", "Red", "Blue", "Green", "Yellow", "Magenta"
        };

        new AlertDialog.Builder(this)
                .setTitle("색상 선택")
                .setItems(colorNames, (dialog, which) -> {
                    currentColor = colors[which];
                    drawingView.setPaintColor(currentColor);
                })
                .show();
    }

    private void showThicknessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("굵기 선택");

        SeekBar seekBar = new SeekBar(this);
        seekBar.setMax(100);
        seekBar.setProgress(currentThickness);

        builder.setView(seekBar);
        builder.setPositiveButton("확인", (dialog, which) -> {
            currentThickness = seekBar.getProgress();
            if (currentThickness < 1) currentThickness = 1;
            drawingView.setStrokeWidth(currentThickness);
        });
        builder.setNegativeButton("취소", null);
        builder.show();
    }
}
