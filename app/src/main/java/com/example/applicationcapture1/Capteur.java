package com.example.applicationcapture1;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public class Capteur implements SensorEventListener {

    float x, y, z;



    public void onSensorChanged(int sensor, float[] values) {
        x = values[0];

        y = values[1];

        z = values[2];
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
