package musicapp.persistence.sqlite;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import java.util.Calendar;
import controller.musicapp.musicapp.R;
import musicapp.constants.InternetConnections;
import musicapp.controller.Login;
import musicapp.exceptions.NotValidAgeException;
import musicapp.exceptions.NotValidTelephoneNumberException;
import musicapp.model.User;

public class InputUser extends AppCompatActivity {

    boolean isMayus = false;

    public User user;

    private TextView displayDate;
    private ImageButton pickDate;

    private int pYear;
    private int pMonth;
    private int pDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);

        displayDate = (TextView) findViewById(R.id.tvBirthdate);
        pickDate = (ImageButton) findViewById(R.id.imgPickDate);

        // Get the current date
        final Calendar cal = Calendar.getInstance();
        pYear = cal.get(Calendar.YEAR);
        pMonth = cal.get(Calendar.MONTH);
        pDay = cal.get(Calendar.DAY_OF_MONTH);

        // Display the current date in the TextView
        updateDisplay();
    }

    public void onClickCancel(View view) {
        setContentView(R.layout.activity_login);
    }

    private void createUserWithSqLite(User user){
        //private void createUserWithSqLite(String name, String password, String lastname, String sex, Date birthday, String phone, String email){
        UserHelper helper = new UserHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();


        // DB Input method
        ContentValues values = new ContentValues();
        values.put(UserContract.UserInfo.NAME_COLUMN_NAME, user.getName());
        values.put(UserContract.UserInfo.NAME_COLUMN_PASSWORD, user.getPassword());
        values.put(UserContract.UserInfo.NAME_COLUMN_LASTNAME, user.getLastname());
        values.put(UserContract.UserInfo.NAME_COLUMN_SEX, user.getSex());
        values.put(UserContract.UserInfo.NAME_COLUMN_BIRTHDAY, user.getBirthday());
        values.put(UserContract.UserInfo.NAME_COLUMN_PHONE, user.getTelephone());
        values.put(UserContract.UserInfo.NAME_COLUMN_EMAIL, user.getEmail());
        db.insert(UserContract.UserInfo.NAME_TABLE, null, values);
        db.close();
        helper.close();


    }
    private void createWithOrmLite(User user){ Dao<User, String> userDao = null;
        String databaseUrl = "jdbc:postgresql://192.168.205.68:3306/musicapp";
        // create a connection source to our database
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource(databaseUrl);
            userDao = DaoManager.createDao(connectionSource, User.class);
            // if you need to create the 'accounts' table make this call
            //TableUtils.createTable(connectionSource, User.class);
            // create an instance of Account
            //String name = "Jim Smith";
            //Account account = new Account(user.getName(), user.getPassword());
            // persist the account object to the database
            userDao.createOrUpdate(user);
            // retrieve the account
            User u2 = userDao.queryForId(user.getName());
            // show its password
            System.out.println("Account: " + u2.getPassword());
            // close the connection source
            connectionSource.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

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

    public void onClick(View view) throws NotValidAgeException, NotValidTelephoneNumberException {
        switch (view.getId()) {
            case R.id.btnCreateUser:
                UserHelper helper = new UserHelper(this);
                SQLiteDatabase db = helper.getWritableDatabase();


                String name = ((EditText) findViewById(R.id.name)).getText().toString();
                String pwd = ((EditText) findViewById(R.id.password)).getText().toString();
                String lastname = ((EditText) findViewById(R.id.price)).getText().toString();


                String phone = ((EditText) findViewById(R.id.hour)).getText().toString();
                String email = ((EditText) findViewById(R.id.email)).getText().toString();
                //int id;

                Context context = getApplicationContext();

                // Input errors
                if (phone.length() > 9 || phone.length() < 9) {
                    CharSequence text = "Not a valid telephone number";
                    //int duration = Toast.LENGTH_SHORT;

                    //Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                    //toast.show();

                    View phoneEd =  findViewById(R.id.phoneMessage);
                    phoneEd.setVisibility(View.VISIBLE);


                    // throw new NotValidTelephoneNumberException(text.toString());
         /* }else if (age > 100 || age < 5) {
            CharSequence text = "Not a valid age";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            //throw new NotValidAgeException(text.toString());

        */}

                if (pwd.length() < 8 || pwd.length() > 14) {
                    CharSequence text = "Error, not correct number of characters (Maximum 14 - Minimum 8)";
                    //int duration = Toast.LENGTH_SHORT;

                    //Toast toast = Toast.makeText(context, text, duration);
                    //toast.show();


                    //throw new NotValidAgeException(text.toString());

                } if (phone.length() == 9 && pwd.length() >= 8 && pwd.length() <= 14){

                View phonedEd =  findViewById(R.id.phoneMessage);
                phonedEd.setVisibility(View.INVISIBLE);

                View passwordEd =  findViewById(R.id.pwdMessage);
                passwordEd.setVisibility(View.INVISIBLE);
                // Create User
                user = new User();
                user.setName(name);
                user.setLastname(lastname);
                // user.setSex(sex);
                //user.setBirthday(String.valueOf(birthday));
                user.setTelephone(phone);
                user.setEmail(email);
                user.setPassword(pwd);

                createUserWithSqLite(user);
                if (InternetConnections.searchConexion(this)){
                    createWithOrmLite(user);
                }

                CharSequence text = "The user " + name + " has been created.";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }
                break;
            case R.id.imgPickDate:
                showDialog(DATE_DIALOG_ID);
                break;
            case R.id.btnCancel:
                Intent intentLogin = new Intent(getBaseContext(), Login.class);
                startActivity(intentLogin);
                break;
        }

    }

}