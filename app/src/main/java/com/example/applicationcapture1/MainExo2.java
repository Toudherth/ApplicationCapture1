package com.example.applicationcapture1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainExo2 extends AppCompatActivity implements SensorEventListener{
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private static final float SHAKE_THRESHOLD = 3.25f;
    private static final int MIN_TIME_BETWEEN_SHAKES_MILLISECS = 1000;
    private long mLastShakeTime;
    protected TextView tv;
    protected LinearLayout rl;

    CameraDevice cameraDevice;
    private CameraManager cameraManager;
    private CameraCharacteristics cameraCharacteristics;
    String cameraId;
    float [] history = new float[2];
    String [] direction = {"NONE","NONE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_exo2);


        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (mAccelerometer != null) {
            mSensorManager.registerListener((SensorEventListener) this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }

        cameraManager = (CameraManager)
                getSystemService(Context.CAMERA_SERVICE);
        try {
            cameraId = cameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

       // this.tv = findViewById(R.id.textView);

        this.rl = findViewById(R.id.rl2);
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener((SensorEventListener) this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener((SensorEventListener) this);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onSensorChanged(SensorEvent event) {


    /*    if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            long curTime = System.currentTimeMillis();
            if ((curTime - mLastShakeTime) > MIN_TIME_BETWEEN_SHAKES_MILLISECS) {

                float x = event.values[0];
                float y = event.values[1];
                float z = event.values[2];

                double acceleration = Math.sqrt(Math.pow(x, 2) +
                        Math.pow(y, 2) +
                        Math.pow(z, 2)) - SensorManager.GRAVITY_EARTH;
                if (acceleration > SHAKE_THRESHOLD) {
                    mLastShakeTime = curTime;
                    Boolean light = true;
                    if (light) {
                        try {
                            cameraManager.setTorchMode(cameraId, true);
                            System.out.println("CAMERA ON CAMERA ON CAMERA ON");
                        } catch (CameraAccessException e) {
                            e.printStackTrace();
                        }
                        light = false;
                    } else {
                        try {
                            cameraManager.setTorchMode(cameraId, false);
                            System.out.println("CAMERA OFF CAMERA OFF CAMERA OFF");
                        } catch (CameraAccessException e) {
                            e.printStackTrace();
                        }

                        light = true;
                    }
                }
            }
        }*/


        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        if ( x <= 0.15 ){
            rl.setBackgroundColor(Color.parseColor("#47b550"));
        }
        if(x > 0.15 && x <= 1 ){
            rl.setBackgroundColor(Color.parseColor("#000000"));
        }
        if ( x > 1 ){
            rl.setBackgroundColor(Color.parseColor("#b53333"));
        }

        float xChange = history[0] - event.values[0];
        float yChange = history[1] - event.values[1];

        history[0] = event.values[0];
        history[1] = event.values[1];

        if (xChange > 2){
            direction[0] = "GAUCHE";
        }
        else if (xChange < -2){
            direction[0] = "DROITE";
        }

        if (yChange > 2){
            direction[1] = "BAS";
        }
        else if (yChange < -2){
            direction[1] = "HAUT";
        }

        //  String res = "DIRECTION : " + direction[0] + ",  " +  direction[1];
        // tv.setText(res);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}