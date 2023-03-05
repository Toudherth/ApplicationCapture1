package com.example.applicationcapture1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;

public class MainExo7 extends AppCompatActivity  implements LocationListener{

    private LocationManager locationManager;
    private LocationListener locationListener;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("je suis ici ======================================");
        setContentView(R.layout.activity_main_exo7);
        textView= findViewById(R.id.textView4);


        // Initialiser le LocationManager
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        System.out.println("je suis ici ======================================");

        // Vérifier si les autorisations sont accordées
        if (ActivityCompat.checkSelfPermission(MainExo7.this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(MainExo7.this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {
            // Si les autorisations ne sont pas accordées, demander la permission
            ActivityCompat.requestPermissions(MainExo7.this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            }, 1);
            return;
        }
        // Obtenir l'objet LocationManager
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // Demander la mise à jour de la position
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) MainExo7.this);
    }



    // Méthode appelée lorsque la position change
    @Override
    public void onLocationChanged(Location location) {
        // Afficher la position dans le TextView
        textView.setText("Latitude : " + location.getLatitude() +
                "\nLongitude : " + location.getLongitude());
    }

    // Méthodes appelées lorsqu'il y a un changement dans l'état du fournisseur de position
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // Ne rien faire
    }

    @Override
    public void onProviderEnabled(String provider) {
        // Ne rien faire
    }

    @Override
    public void onProviderDisabled(String provider) {
        // Afficher un message d'erreur
        Toast.makeText(this, "Veuillez activer le GPS", Toast.LENGTH_SHORT).show();
    }

    // Méthode appelée lorsqu'on demande la permission d'accès à la position
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                // Si les autorisations sont accordées, demander la mise à jour de la position
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
            } else {
                // Si les autorisations ne sont pas accordées, afficher un message d'erreur
                Toast.makeText(this, "Veuillez accorder les permissions pour accéder à la position", Toast.LENGTH_SHORT).show();
            }
        }
    }



}
