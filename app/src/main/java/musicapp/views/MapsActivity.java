package musicapp.views;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import controller.musicapp.musicapp.Local_Boveda;
import controller.musicapp.musicapp.Local_Razz;
import controller.musicapp.musicapp.Local_SrLobo;
import controller.musicapp.musicapp.R;
import musicapp.constants.Constants;

public class MapsActivity extends FragmentActivity implements
        OnMapReadyCallback,
        ActivityCompat.OnRequestPermissionsResultCallback,
        GoogleMap.OnMarkerClickListener,
        GoogleMap.OnMapClickListener {

    private GoogleMap mMap;
    private List<Loc> locations = new ArrayList<Loc>();
    Constants constants = new Constants();

    // QUAN ES CREA (SE'N VA A LA LOCALITZACIÓ DE QUI OBRE EL GOOGLEMAPS)
    //
    // BOVEDA
    LatLng inici_latlng = null;
    MarkerOptions inici_markerOptions = null;

    LatLng bcn_latlng = new LatLng(41.385061, 2.173407);
    LatLng lobo_latlng = new LatLng(41.395956, 2.188540);
    LatLng boveda_latlng = new LatLng(41.398532, 2.200075);
    LatLng razz_latlng =  new LatLng(41.397790, 2.191043);
    MarkerOptions markerOptionsBCN = new MarkerOptions().position(bcn_latlng).title("Marker in BCN");
    MarkerOptions markerOptionsLobo = new MarkerOptions().position(lobo_latlng).title("Sr Lobo");
    MarkerOptions markerOptionsBoveda = new MarkerOptions().position(boveda_latlng).title("Boveda");
    MarkerOptions markerOptionsRazz = new MarkerOptions().position(razz_latlng).title("Razzmatazz");

    static final int MY_LOCATION_REQUEST_CODE = 5;
    static final String[] Permission_Location = { controller.musicapp.musicapp.Manifest.permission.ACCESS_FINE_LOCATION };
    private boolean mPermissionDenied = false;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    String[] PermissionsLocation =
            {
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent i = getIntent();
        Bundle b = i.getExtras();

        inici_latlng = (LatLng) b.get("latlng");
        inici_markerOptions = (MarkerOptions) b.get("markerOptions");


        locations = constants.getLocsList();
        int len = locations.size();
        final String locals = "";
        final String[] osArray = new String[len];
        for(int it=0; it<len; it++){
            osArray[it] = locations.get(it).getName();
        }
        Log.d("NOMS", locals);
        Log.d("NOMS", osArray.toString());


        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.getStatusBarBackgroundDrawable();
        drawerLayout.setFitsSystemWindows(true);

        ListView listViewLeft = (ListView) findViewById(R.id.lvl);
        final ListView listViewRight = (ListView) findViewById(R.id.lvr);
        final String[] lvl_options = { "Opción 1 l", "Opción 2 l", "Opción 3 l", "Opción 4 l" };
        final String[] lvr_options = { "Opción 1 r", "Opción 2 r", "Opción 3 r", "Els meus locals"};
        listViewLeft.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listViewRight.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);



        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.drawer_list_items, osArray);

        listViewRight.setAdapter(arrayAdapter);
        listViewLeft.setAdapter(arrayAdapter);


        listViewLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(MapsActivity.this, "Item: " + osArray[arg2], Toast.LENGTH_SHORT).show();
                //drawerLayout.closeDrawers();
            }
        });

        listViewRight.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(MapsActivity.this, "Item: " + osArray[arg2], Toast.LENGTH_SHORT).show();
                //drawerLayout.closeDrawers();


                Loc loc = locations.get(arg2);
                MarkerOptions mo = new MarkerOptions().position(loc.getLatLng()).title(loc.getName());

                if (listViewRight.getChildAt(arg2).isEnabled()){
                    mMap.addMarker(mo);
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(mo.getPosition()));
                } else {
                    mo.visible(false);
                }
            }




        });

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
        Log.d("AAAAA", "entra en funció onMapReady");
        mMap = googleMap;


        mMap.setOnMarkerClickListener(this);

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng arg0) {
                Log.d("arg0", arg0.latitude + "-" + arg0.longitude);
            }
        });

        mMap.addMarker(markerOptionsBCN);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bcn_latlng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(bcn_latlng, 12.0f));


        int hasPermission = ContextCompat.checkSelfPermission(this, controller.musicapp.musicapp.Manifest.permission.ACCESS_FINE_LOCATION);
        if (hasPermission == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        }


        if (inici_latlng != null && inici_markerOptions!= null){
            mMap.addMarker(new MarkerOptions().position(inici_latlng).title(inici_markerOptions.getTitle()));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(inici_latlng));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(inici_latlng, 16.5f));

        }


    }

    public void carregaLocalitzacions(List<Loc> localitzacions){
        int len = localitzacions.size();
        for (int i=0; i<len; i++){
            Loc loc = localitzacions.get(i);
            mMap.addMarker(new MarkerOptions().position(loc.getLatLng()).title(loc.getName()));
        }
    }


    public void onMapClick(LatLng latLng) {
        Log.d("MARKER", "ENTRES onmapclick");
        if (latLng.equals(markerOptionsBCN.getPosition())){
            Log.d("MARKER", "estàs a bcn");
        }
    }


    private void enableMyLocation() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Toast.makeText(this, "ENTRE ONREQUESTPERMISSIONRESULT", Toast.LENGTH_LONG).show();
        if (requestCode == MY_LOCATION_REQUEST_CODE) {
            if (permissions.length == 1 &&
                    permissions[0] == Permission_Location[0] &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                mMap.getUiSettings().setMyLocationButtonEnabled(true);

                Toast.makeText(this, "SET MY LOCATION ENABLED", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "SET MY LOCATION DISABLED", Toast.LENGTH_LONG).show();
            }
        }
    }

    // Add a marker in Sydney and move the camera
       /* LatLng sydney = new LatLng(-34, 151);

        */
    //  if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
    //    Log.d("AAAAA", "entra a comprobació 1");
    //   mMap.setMyLocationEnabled(true);
    //   mMap.getUiSettings().setMyLocationButtonEnabled(true);
    //   return;
    // }




    private void changeCamera(CameraUpdate update, GoogleMap.CancelableCallback callback) {
        mMap.animateCamera(update, Math.max(2, 1), callback);
        mMap.moveCamera(update);
    }


    static final CameraPosition BCN_INICI =
            new CameraPosition.Builder().target(new LatLng(41.385061, 2.173407))
                    .zoom(15.5f)
                    .bearing(0)
                    .tilt(25)
                    .build();

    static boolean canGo = false;
    long time_start, time_end;


    @Override
    public boolean onMarkerClick(Marker marker) {


        time_end = System.currentTimeMillis();
        if ( time_end - time_start < 1000 ){
            canGo = true;
        } else {
            canGo = false;
        }
        time_start = System.currentTimeMillis();


        if (marker.getTitle().equalsIgnoreCase(markerOptionsBoveda.getTitle())){
            if (canGo){
                Intent i2 = new Intent(this, Local_Boveda.class);
                startActivity(i2);
            }
        } else if (marker.getTitle().equalsIgnoreCase(markerOptionsLobo.getTitle())){
            if (canGo){
                Intent i2 = new Intent(this, Local_SrLobo.class);
                startActivity(i2);
            }
        } else if (marker.getTitle().equalsIgnoreCase(markerOptionsRazz.getTitle())){
            if (canGo){
                Intent i2 = new Intent(this, Local_Razz.class);
                startActivity(i2);
            }
        }
        return false;
    }






}
