package com.itd.Geolocalizacion;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity {
    private LocationManager locManager;
    private LocationListener locListener;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView latitud = (TextView)findViewById(R.id.lblPosLatitud);
        TextView longitud = (TextView)findViewById(R.id.lblPosLongitud);
        TextView presicion = (TextView)findViewById(R.id.lblPresicion);

        Button prende = (Button)findViewById(R.id.btnActualizar);
        Button apaga = (Button)findViewById(R.id.btnApagar);
        TextView estado = (TextView)findViewById(R.id.lblEstado);

        //Comenzamos a controlar los eventos de los objetos
        //Acutalizar el estado del dispositivo
        prende.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comienzaLocalizacion();
            }
        });
        //Apagar el dispositivo
        apaga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apagaLocalizacion();
            }
        });

    }

    private void comienzaLocalizacion() {
        //Obtenemos una referencia al servicio de localizacion del sistema
locManager =
        (LocationManager)getSystemService(Context.LOCATION_SERVICE);

Location ubicacion =
        locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
mostrarUbicacion(ubicacion);

locListener = new LocationListener() {
    @Override
    public void onLocationChanged(Location location) {
        mostrarUbicacion(location);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onProviderEnabled(String provider) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onProviderDisabled(String provider) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
};
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                30000, 0,locListener);
    }
}
