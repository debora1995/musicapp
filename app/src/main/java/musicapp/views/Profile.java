package musicapp.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import controller.musicapp.musicapp.R;
import musicapp.persistence.sqlite.InputEvent;

public class Profile extends AppCompatActivity {

    private TextView userName;
    private ScrollView pubScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userName = (TextView) findViewById(R.id.tvUserName);
        pubScroll = (ScrollView) findViewById(R.id.publicationsScroll);

        Intent intentPrincipal = getIntent();

        if (intentPrincipal.equals(0)) {
            //mostrar events propis PENDENTS
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
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

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCreateEvent:
                Intent intentInputEvent = new Intent(this, InputEvent.class);
                startActivity(intentInputEvent);
                break;
        }
    }
}
