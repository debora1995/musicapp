package musicapp.persistence.sqlite;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import controller.musicapp.musicapp.R;
import musicapp.model.Event;

public class InputEvent extends AppCompatActivity {

    private final int SELECT_PHOTO = 1;
    private ImageView imageView;

    private TextView displayDate;
    private ImageButton pickDate;

    private int pYear;
    private int pMonth;
    private int pDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_event);

        displayDate = (TextView) findViewById(R.id.tvDateEvent);
        pickDate = (ImageButton) findViewById(R.id.imgDateEvent);

        // Get the current date
        final Calendar cal = Calendar.getInstance();
        pYear = cal.get(Calendar.YEAR);
        pMonth = cal.get(Calendar.MONTH);
        pDay = cal.get(Calendar.DAY_OF_MONTH);

        // Display the current date in the TextView
        updateDisplay();
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
        displayDate.setText(
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

    public void onClick(View view){
        switch (view.getId()) {
            case R.id.tvPhotoEvent:
                Intent photoPick = new Intent(Intent.ACTION_PICK);
                photoPick.setType("image/*");
                startActivityForResult(photoPick, SELECT_PHOTO);
                break;
            case R.id.imgDateEvent:
                showDialog(DATE_DIALOG_ID);
                break;
            case R.id.btnCreateEvent:
                String name = ((EditText) findViewById(R.id.name)).getText().toString();
                imageView = (ImageView) findViewById(R.id.photoEvent);
                java.sql.Date day = java.sql.Date.valueOf(((TextView) findViewById(R.id.tvDateEvent)).getText().toString());
                Time hour = Time.valueOf(((EditText) findViewById(R.id.hour)).getText().toString());
                Float price = Float.parseFloat(((EditText) findViewById(R.id.price)).getText().toString());
                String observations =((EditText) findViewById(R.id.observations)).getText().toString();
                //int id;

                // Create Event
                Event event = new Event();
                event.setName(name);
                event.setDay(day);
                event.setHour(hour);
                event.setPrice(price);
                event.setObservations(observations);

                createEventWithSqLite(event);

                Context context = getApplicationContext();
                CharSequence text = "The Event " + name + " has been created.";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                break;
            case R.id.btnCancelEvent:
                break;
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch(requestCode) {
            case SELECT_PHOTO:
                if(resultCode == RESULT_OK){
                    try {
                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        imageView.setImageBitmap(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                }
        }
    }

    private void createEventWithSqLite(Event event){
        UserHelper helper = new UserHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        // DB Input method
        ContentValues values = new ContentValues();
        values.put(UserContract.Event.NAME_COLUMN_NAME, event.getName());
        values.put(UserContract.Event.NAME_COLUMN_PHOTO, event.getPhoto());
        values.put(UserContract.Event.NAME_COLUMN_DAY, event.getDay().toString());
        values.put(UserContract.Event.NAME_COLUMN_HOUR, event.getHour().toString());
        values.put(UserContract.Event.NAME_COLUMN_PRICE, event.getPrice());
        values.put(UserContract.Event.NAME_COLUMN_OBSERVATIONS, event.getObservations());
        db.insert(UserContract.Event.NAME_TABLE, null, values);
        db.close();
        helper.close();

    }

    private void createUserEventWithSqLite(Event event){

        UserHelper helper = new UserHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        // DB Input method
        ContentValues values = new ContentValues();
        //values.put(UserContract.User_Events.NAME_COLUMN_USER_ID, User.class);
        values.put(UserContract.User_Events.NAME_COLUMN_EVENT_ID, event.getId());
        db.insert(UserContract.User_Events.NAME_TABLE, null, values);

        db.close();
        helper.close();

    }

    private void createUserEventWithSqLite(String name, Date day, Time hour, Float price ,String observations){
        UserHelper helper = new UserHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        // Create Event
        Event event = new Event();
        event.setName(name);

        event.setDay((java.sql.Date) day);
        //event.setHour(hour);
        //event.setPrice(Float.parseFloat(price));

        // DB Input method
        ContentValues values = new ContentValues();
        values.put(UserContract.Event.NAME_COLUMN_NAME, event.getName());
        values.put(UserContract.Event.NAME_COLUMN_PHOTO, event.getPhoto());
        //values.put(UserContract.Event.NAME_COLUMN_LOCALIZATION, event.getLocalitzation());
        //values.put(UserContract.Event.NAME_COLUMN_DAY, event.getDay().toString());
        //values.put(UserContract.Event.NAME_COLUMN_HOUR, event.getHour().toString());
        //values.put(UserContract.Event.NAME_COLUMN_PRICE, event.getPrice());
        db.insert(UserContract.Event.NAME_TABLE, null, values);
        db.close();
        helper.close();

    }
}