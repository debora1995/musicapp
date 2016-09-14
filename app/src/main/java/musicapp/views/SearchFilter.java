package musicapp.views;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;

import controller.musicapp.musicapp.R;

public class SearchFilter extends AppCompatActivity {

    private TextView pDisplayDate;
    private ImageButton pPickDate;

    private int pYear;
    private int pMonth;
    private int pDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_filter);

        pDisplayDate = (TextView) findViewById(R.id.tvFecha);
        pPickDate = (ImageButton) findViewById(R.id.calendari);

        // Get the current date
        final Calendar cal = Calendar.getInstance();
        pYear = cal.get(Calendar.YEAR);
        pMonth = cal.get(Calendar.MONTH);
        pDay = cal.get(Calendar.DAY_OF_MONTH);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_filter, menu);
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

    // This integer will uniquely define the dialog to be used for displaying date picker
    static final int DATE_DIALOG_ID = 0;

    // Callback received when the user "picks" a date in the dialog
    private DatePickerDialog.OnDateSetListener pDateSetListener =
            new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    pYear = year;
                    pMonth = monthOfYear;
                    pDay = dayOfMonth;
                    updateDisplay();
                }
            };

    // Updates the date in the TextView
    private void updateDisplay() {
        pDisplayDate.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append(pMonth + 1).append("/")
                        .append(pDay).append("/")
                        .append(pYear).append(" "));
    }

    // Create a new dialog for date picker
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        pDateSetListener,
                        pYear, pMonth, pDay);
        }
        return null;
    }

    // Listener for click event of the button
  /*  public void fecha(View view) {
        showDialog(DATE_DIALOG_ID);
    }*/

    public void onClick (View view) {
        switch (view.getId()) {
            case R.id.btnSearchFilt:
                //look for events
                break;
            // Listener for click event of the button
            case R.id.calendari:
                showDialog(DATE_DIALOG_ID);
                break;
        }
    }
}
