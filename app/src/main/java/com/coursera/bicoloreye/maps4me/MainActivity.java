package com.coursera.bicoloreye.maps4me;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.coursera.bicoloreye.maps4me.maps.MapsActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar= (Toolbar) findViewById(R.id.myActionBar);
        if(miActionBar !=null){
            setSupportActionBar(miActionBar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    public void irMapas(View view){
        Intent intent=new Intent(this,MapsActivity.class);
        startActivity(intent);
    }

    public void clic4Map (View view){
        Intent iMapas=new Intent(this,MapsActivity.class);
        switch (view.getId()){
            case R.id.ibChurch:
                Toast.makeText(this,"Mi Iglesia",Toast.LENGTH_SHORT).show();
                iMapas.putExtra("favorito",R.drawable.church);
                iMapas.putExtra("lat",4.94033478906513);
                iMapas.putExtra("lon",-73.96014402737501);
                iMapas.putExtra("nombre","Mi Iglesia");
                startActivity(iMapas);
                break;
            case R.id.ibHamburguer:
                Toast.makeText(this,"Mi Restaurante de Hamburguesas",Toast.LENGTH_SHORT).show();
                iMapas.putExtra("favorito",R.drawable.hamburger);
                iMapas.putExtra("lat",4.940388233942842);
                iMapas.putExtra("lon",-73.96720360134178);
                iMapas.putExtra("nombre","Mi Restaurante de Hamburguesas");

                startActivity(iMapas);
                break;
            case R.id.ibHome:
                Toast.makeText(this,"Mi Casa",Toast.LENGTH_SHORT).show();
                iMapas.putExtra("favorito",R.drawable.home);
                iMapas.putExtra("lat",4.97668152455171);
                iMapas.putExtra("lon",-73.96066110412967);
                iMapas.putExtra("nombre","Mi Casa");
                startActivity(iMapas);
                break;
            case R.id.ibShopping:
                Toast.makeText(this,"Mi Lugar de compras",Toast.LENGTH_SHORT).show();
                iMapas.putExtra("favorito",R.drawable.shopping);
                iMapas.putExtra("lat",4.93999931799895);
                iMapas.putExtra("lon",-73.95549153833142);
                iMapas.putExtra("nombre","Mi Lugar de compras");
                startActivity(iMapas);

                break;
            default:
                Toast.makeText(this,"Default:"+view.getId()+"",Toast.LENGTH_SHORT).show();
        }
    }
}