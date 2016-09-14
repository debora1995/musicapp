package musicapp.persistence.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import musicapp.constants.Constants;


/**
 * Created by ausias on 25/04/16.
 */
public class UserHelper extends SQLiteOpenHelper {

    public UserHelper(Context context) {
        super(context, Constants.nameUserFile, null,Constants.version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // First time execution
        // Creating DB's and other activities of inizialization
        db.execSQL(UserContract.UserInfo.SQL_CREATE_TABLE);
        db.execSQL(UserContract.Event.SQL_CREATE_TABLE);
        db.execSQL(UserContract.User_Events.SQL_CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
