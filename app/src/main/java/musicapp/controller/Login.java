package musicapp.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import controller.musicapp.musicapp.R;
import musicapp.persistence.sqlite.InputUser;
import musicapp.views.ForgotPass;
import musicapp.views.Principal;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
            case R.id.btnGmail:
                Intent intentPrincipalGmail = new Intent(this, Principal.class);
                startActivity(intentPrincipalGmail);
                setContentView(R.layout.activity_principal);
                break;

            case R.id.btnUser:
                Intent intentPrincipalUser = new Intent(this, Principal.class);
                startActivity(intentPrincipalUser);
                setContentView(R.layout.activity_principal);
                break;

            case R.id.btnNewUser:
                Intent intentCreateAccount = new Intent(this, InputUser.class);
                startActivity(intentCreateAccount);
                break;

            case R.id.btnForgotPass:
                Intent intentForgotPass = new Intent(this, ForgotPass.class);
                startActivity(intentForgotPass);
                break;

        }

    }
}
