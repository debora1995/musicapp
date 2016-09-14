package controller.musicapp.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import musicapp.views.MapsActivity;

public class Local_SrLobo extends AppCompatActivity {

    private LatLng lobo_latlng = new LatLng(41.395956, 2.188540);
    private MarkerOptions markerOptionsLobo = new MarkerOptions().position(lobo_latlng).title("Sr Lobo");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local__sr_lobo);
    }


    public void ongooglemaps(View v){
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("latlng", lobo_latlng);
        intent.putExtra("markerOptions", markerOptionsLobo);
        startActivity(intent);

    }
}
