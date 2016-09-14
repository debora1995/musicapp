package musicapp.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import controller.musicapp.musicapp.R;
import musicapp.controller.Login;

public class Identification extends AppCompatActivity {

    private TextView wrong;
    private String wrongText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identification);

        wrong = (TextView) findViewById(R.id.tvWrongIdentification);
        wrongText = wrong.getText().toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_identification, menu);
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
            case R.id.btnSignIn:
                //Comprovar si les dades d'entrada son correctes
                //if (correcte) {
                Intent intentPrincipal = new Intent(this, Principal.class);
                startActivity(intentPrincipal);
                break;
                 //}
            /*
            else { Toast.makeText(Identification.this, wrongText, Toast.LENGTH_SHORT).show(); }
             */

            case R.id.btnCancelSignIn:
                Intent intentLogin = new Intent(this, Login.class);
                startActivity(intentLogin);
                break;
        }
    }
}
