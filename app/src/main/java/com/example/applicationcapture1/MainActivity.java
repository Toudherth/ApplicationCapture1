package com.example.applicationcapture1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager ; //= (SensorManager) getSystemService(Context.SENSOR_SERVICE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bnt1 = findViewById(R.id.button1);
        bnt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainExo1.class);
                startActivity(intent);
            }
        });

        Button bnt2 = findViewById(R.id.button2);
        bnt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainExo2.class);
                startActivity(intent);
            }
        });

        Button bnt3 = findViewById(R.id.button3);
        bnt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainExo3.class);
                startActivity(intent);
            }
        });

        Button bnt4 = findViewById(R.id.button4);
        bnt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainExo4.class);
                startActivity(intent);
            }
        });

        Button bnt5 = findViewById(R.id.button5);
        bnt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainExo5.class);
                startActivity(intent);
            }
        });

        Button bnt6 = findViewById(R.id.button6);
        bnt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainExo6.class);
                startActivity(intent);
            }
        });


        Button bnt7 = findViewById(R.id.button7);
        bnt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainExo7.class);
                startActivity(intent);
            }
        });


    }


}