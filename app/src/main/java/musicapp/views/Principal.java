package musicapp.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import controller.musicapp.musicapp.Local_Boveda;
import controller.musicapp.musicapp.Local_Razz;
import controller.musicapp.musicapp.Local_SrLobo;
import controller.musicapp.musicapp.R;
import musicapp.controller.Login;
import musicapp.model.Event;
import musicapp.persistence.sqlite.UpdateUser;

public class Principal extends AppCompatActivity {

    private String[] menuItems, perfilItems;
    private ListView menuList, perfilList;
    private ScrollView scroll;;
    private ImageButton searchEvents;

    public void addEventScreen(View view){
        Event event = new Event();
        List<Event> events;

        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:Login");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM Event");
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while(rs.next()){
                try {
                    System.out.println(rs.getString(1));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Intent events = getIntent();
        if(events.equals(1)) {
            //filtrar events per data
        }

        searchEvents = (ImageButton) findViewById(R.id.imgSearch);
        scroll = (ScrollView) findViewById(R.id.scrollView);

        //Get menu and profile list items from xml
        menuItems = getResources().getStringArray(R.array.items_menu);
        perfilItems = getResources().getStringArray(R.array.items_perfil);

        menuList = (ListView) findViewById(R.id.right_list);
        perfilList = (ListView) findViewById(R.id.left_list);

        //Set adapter
        menuList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_items,menuItems));
        perfilList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_items, perfilItems));

        //OnClick
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                position = parent.getPositionForView(view);
                switch (position) {
                    case 0:
                        int myEvents = 0;
                        Intent intentEvents = new Intent(getBaseContext(), Profile.class);
                        intentEvents.putExtra("My events",myEvents);
                        startActivity(new Intent(getBaseContext(), Profile.class));
                        break;
                    case 1:
                        int nextEvents = 1;
                        Intent intentNextEvents = new Intent(getBaseContext(), Principal.class);
                        intentNextEvents.putExtra("Next events", nextEvents);
                        break;
                    case 2:
                        startActivity(new Intent(getBaseContext(), AboutUs.class));
                        break;
                }
            }
        });

        perfilList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                position = parent.getPositionForView(view);
                switch (position) {
                    case 0:
                        startActivity(new Intent(getBaseContext(), Profile.class));
                        break;
                    case 1:
                        startActivity(new Intent(getBaseContext(), Configurations.class));
                        break;
                    case 2://close
                        startActivity(new Intent(getBaseContext(), Login.class));
                        break;
                }
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onclic (View v) {
        switch (v.getId()) {
            case R.id.imgSearch:
                startActivity(new Intent(this, SearchFilter.class));
                break;
            case R.id.imgMaps:
                Intent googleMaps = new Intent(this, MapsActivity.class);
                LatLng boveda_latlng = null;
                googleMaps.putExtra("latlng", boveda_latlng);
                MarkerOptions markerOptions = null;
                googleMaps.putExtra("markerOptions", markerOptions);
                startActivity(googleMaps);
                break;
        }
    }

    public void golocal(View v){

        switch (v.getId()) {
            case R.id.ivBoveda:
                startActivity(new Intent(this, Local_Boveda.class));
                break;
            case R.id.ivLobo:
                startActivity(new Intent(this, Local_SrLobo.class));
                break;
            case R.id.ivRazz:
                startActivity(new Intent(this, Local_Razz.class));
                break;
        }

    }
}
