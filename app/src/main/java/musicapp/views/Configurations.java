package musicapp.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import controller.musicapp.musicapp.R;
import musicapp.persistence.sqlite.UpdateUser;

public class Configurations extends AppCompatActivity {

    private String[] configItems;
    private ListView confList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurations);

        //Get menu and profile list items from xml
        configItems = getResources().getStringArray(R.array.items_configurations);
        confList = (ListView) findViewById(R.id.listview);

        //Set adapter
       confList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_items,configItems));

        //OnClick
        confList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                position = parent.getPositionForView(view);
                switch (position) {
                    case 0:
                        startActivity(new Intent(getBaseContext(), UpdateUser.class));
                        break;
                    case 1:
                        //activar ubicacio
                        break;
                    case 2:
                        startActivity(new Intent(getBaseContext(), ShowPopUp.class));
                        break;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_configurations, menu);
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
}
