package com.coursera.bicoloreye.maps4me.maps;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.coursera.bicoloreye.maps4me.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Toolbar miActionBar= (Toolbar) findViewById(R.id.miactionBar);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Intent iMapas=getIntent();
        // Add a marker in Sydney and move the camera
        LatLng favorito = new LatLng(iMapas.getExtras().getDouble("lat"), iMapas.getExtras().getDouble("lon"));
        //mMap.addMarker(new MarkerOptions().position(favorito).title(iMapas.getExtras().getString("nombre")));
        Marker marker = mMap.addMarker(
                new MarkerOptions()
                        .position(favorito)
                        .title(iMapas.getExtras().getString("nombre"))
                        .snippet(iMapas.getExtras().getString("nombre"))
                        .icon(BitmapDescriptorFactory.fromResource(iMapas.getExtras().getInt("favorito"))));

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(favorito));
        CameraUpdate center=CameraUpdateFactory.newLatLng(favorito);
        CameraUpdate zoom=CameraUpdateFactory.zoomTo(17);
        mMap.moveCamera(center);
        mMap.animateCamera(zoom);
    }


}