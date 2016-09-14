package musicapp.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import controller.musicapp.musicapp.R;

public class ForgotPass extends AppCompatActivity {

    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        email = (EditText) findViewById(R.id.etEmail);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_forgot_pass, menu);
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

    public void onClick (View view) {
        switch (view.getId()) {
            case R.id.btnSend:
                String em = email.getText().toString();
                //send email
                Toast.makeText(getBaseContext(), "E-mail has been sent", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnCancel:
                Intent intentPrincipal = new Intent(getBaseContext(), Principal.class);
                startActivity(intentPrincipal);
                break;
        }
    }
}
