package com.example.number;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textViewRandomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textViewRandomNumber = findViewById(R.id.textViewRandomNumber);

    }

    public void GenerateRandom(View view){
        Random random = new Random();
        int randomnumber = random.nextInt(100);
        textViewRandomNumber.setText("난수 :" + randomnumber);
    }
}
