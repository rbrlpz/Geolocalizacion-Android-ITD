package com.itd.Geolocalizacion;

import android.app.Activity;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
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

    }
}
