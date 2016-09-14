package musicapp.persistence.connections;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.DriverManager;
import java.sql.SQLException;

import musicapp.constants.Constants;
import musicapp.persistence.sqlite.UserHelper;

/**
 * Created by ausias on 30/05/16.
 */
public class Connection {


    public SQLiteDatabase db;
    public String databaseUrl = "jdbc:postgresql://192.168.205.68:3306/musicapp";
    public  ConnectionSource connectionSource = null;
    public UserHelper helper;


    public void openWritable(Context c){
        // open the connection source
        helper = new UserHelper(c);
        SQLiteDatabase db = helper.getWritableDatabase();

    }

    public void openReadable(){
        // open the connection source
        try {
            Class.forName("org.sqlite.JDBC");
            java.sql.Connection conn = DriverManager.getConnection("jdbc:sqlite:" + Constants.nameUserFile);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
    public void openORM() {
        // open the connection source

        // create a connection source to our database
        try {
            connectionSource = new JdbcConnectionSource(databaseUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeORM(){
        // close the connection source
        try {
            connectionSource.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void  closeSQLite(){
        db.close();
        helper.close();
    }
}
