package musicapp.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import controller.musicapp.musicapp.R;


public class ShowPopUp extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pop_up);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.4));
    }

    public void onClick (View view) {
        switch (view.getId()) {
            case R.id.btnDeleteAccount:
                //drop user
                break;
            case R.id.btnCancelDelete:
                startActivity(new Intent(this, Principal.class));
        }
    }
}