package com.example.applicationcapture1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainExo2 extends AppCompatActivity {
    private SensorManager sensorManager;
    private Sensor lightSensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_exo2);

        // Obtention d'une référence au gestionnaire de capteurs
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);


        // Vérification de la disponibilité du capteur de luminosité
        if (sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) != null) {
            // Le capteur est disponible, on peut l'utiliser
            lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
            Toast.makeText(this, "Capteur de luminosité disponible", Toast.LENGTH_SHORT).show();
        } else {
            // Le capteur n'est pas disponible, on informe l'utilisateur
            Toast.makeText(this, "Capteur de luminosité indisponible", Toast.LENGTH_SHORT).show();
        }

    }

}