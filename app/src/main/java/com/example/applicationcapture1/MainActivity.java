package com.example.applicationcapture1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    // recuperer une instance de service
    // les captures
    private SensorManager sensorManager ; //= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    // la liste des captures


    private Capteur accelerometre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager= (SensorManager)  getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        listSensor();

        //la presence/ absence  d'un capture

        Sensor defaultProximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);


        Log.v("SensoerActivity ", "defaultProximitySensor =" +defaultProximitySensor.getName());


        Button bnt = findViewById(R.id.button);


        bnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainExo2.class);
                startActivity(intent);
            }
        });

        Button bnt1 = findViewById(R.id.button2);
        bnt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainExo1.class);
                startActivity(intent);
            }
        });

        Button bnt2 = findViewById(R.id.button3);
        bnt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainExo2.class);
                startActivity(intent);
            }
        });

        Button bnt3 = findViewById(R.id.button4);
        bnt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainExo3.class);
                startActivity(intent);
            }
        });

        Button bnt4 = findViewById(R.id.button5);
        bnt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainExo4.class);
                startActivity(intent);
            }
        });

        Button bnt5 = findViewById(R.id.button6);
        bnt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainExo5.class);
                startActivity(intent);
            }
        });


    }

    private void listSensor() {
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        StringBuffer sensorDesc = new StringBuffer();
        for (Sensor sensor : sensors) {
            sensorDesc.append("New sensor detected : \r\n");
            sensorDesc.append("\tName: " + sensor.getName() + "\r\n");
            sensorDesc.append("\tType: "+ sensor.getType() +"/r/n");
            sensorDesc.append("Version: " + sensor.getVersion() + "\r\n");
            sensorDesc.append("Resolution (in the sensor unit): " + sensor.getResolution() + "\r\n");
            sensorDesc.append("Power in mA used by this sensor while in use" + sensor.getPower() +"\r\n");
            sensorDesc.append("Vendor: " + sensor.getVendor() + "\r\n");
            sensorDesc.append("Maximum range of the sensor in the sensor's unit." + sensor.getMaximumRange() + "\r\n");
            sensorDesc.append("Minimum delay allowed between two events in microsecond » +or zero if this sensor only returns a value when the data it's measuring changes » "+ sensor.getMinDelay() + "\r\n");
        }
        Toast.makeText(this, sensorDesc.toString(), Toast.LENGTH_LONG).show();
    }

}