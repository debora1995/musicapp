package controller.musicapp.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import musicapp.views.MapsActivity;

public class Local_Boveda extends AppCompatActivity {
    private LatLng boveda_latlng = new LatLng(41.398532, 2.200075);
    private MarkerOptions markerOptionsBoveda = new MarkerOptions().position(boveda_latlng).title("Boveda");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local__boveda);
    }


    public void ongooglemaps(View v){
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("latlng", boveda_latlng);
        intent.putExtra("markerOptions", markerOptionsBoveda);
        startActivity(intent);

    }

}
