package controller.musicapp.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import musicapp.views.MapsActivity;

public class Local_Razz extends AppCompatActivity {

    private LatLng razz_latlng = new LatLng(41.397790, 2.191043);
    private MarkerOptions markerOptionsRazz = new MarkerOptions().position(razz_latlng).title("Razzmatazz");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local__razz);
    }


    public void ongooglemaps(View v){
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("latlng", razz_latlng);
        intent.putExtra("markerOptions", markerOptionsRazz);
        startActivity(intent);

    }

}
