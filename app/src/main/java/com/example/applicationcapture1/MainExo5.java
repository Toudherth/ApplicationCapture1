package com.example.applicationcapture1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainExo5 extends AppCompatActivity {

    ConstraintLayout cl;
    TextView ProximitySensor, data;
    ImageView iv;
    SensorManager mySensorManager;
    Sensor myProximitySensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_exo5);

        ProximitySensor = (TextView) findViewById(R.id.textView);
        data = (TextView) findViewById(R.id.textView2);
        iv = (ImageView) findViewById(R.id.imageView);


        mySensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        myProximitySensor = mySensorManager.getDefaultSensor(
                Sensor.TYPE_PROXIMITY);
        if (myProximitySensor == null) {
            ProximitySensor.setText("No Proximity Sensor!");
        } else {
            mySensorManager.registerListener(proximitySensorEventListener, myProximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        }

    }

    SensorEventListener proximitySensorEventListener
            = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent event) {
            // TODO Auto-generated method stub
            if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
                if (event.values[0] == 0) {
                    data.setText("Near");
                    iv.setImageDrawable(getDrawable(R.drawable.pexle));
                } else {
                    data.setText("Away");
                    iv.setImageDrawable(getDrawable(R.drawable.tree));
                }
            }
        }


        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

    };
}
