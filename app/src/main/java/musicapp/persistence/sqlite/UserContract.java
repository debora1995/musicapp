package musicapp.persistence.sqlite;

import android.provider.BaseColumns;

/**
 * Created by ausias on 25/04/16.
 */
public class UserContract {
    // Every class for every DB

    public static class UserInfo implements BaseColumns {
        // One string for column
        // To implements BaseColumns, column _ID appears

        public static final String NAME_TABLE = "UserInfo";
        public static final String NAME_COLUMN_NAME = "name";
        public static final String NAME_COLUMN_PASSWORD = "password";
        public static final String NAME_COLUMN_LASTNAME = "lastname";
        public static final String NAME_COLUMN_SEX = "sex";
        public static final String NAME_COLUMN_BIRTHDAY = "birthday";
        public static final String NAME_COLUMN_PHONE = "phone";
        public static final String NAME_COLUMN_EMAIL = "email";

        // Every String for every SQL sentence
        // Execute CREATE and DROP
        public static final String SQL_CREATE_TABLE =
                " CREATE TABLE " + NAME_TABLE  + " ( "
                + _ID + " SERIAL PRIMARY KEY, "
                + NAME_COLUMN_NAME + " varchar(15), "
                + NAME_COLUMN_PASSWORD + " text,  "
                + NAME_COLUMN_LASTNAME + " varchar(29), "
                + NAME_COLUMN_SEX + " integer, "
                + NAME_COLUMN_BIRTHDAY + " date, "
                + NAME_COLUMN_PHONE + " varchar(12), "
                + NAME_COLUMN_EMAIL + " varchar(20));";


        public final String SQL_DROP_TABLE = " DROP TABLE IF EXISTS " + NAME_TABLE + " CASCADE";

    }

    public static class Event implements BaseColumns {
        // One string for column
        // To implements BaseColumns, column _ID appears

        public static final String NAME_TABLE = "Event";
        public static final String NAME_COLUMN_NAME = "name";
        public static final String NAME_COLUMN_PHOTO = "photo";
        public static final String NAME_COLUMN_DAY = "day";
        public static final String NAME_COLUMN_HOUR = "hour";
        public static final String NAME_COLUMN_PRICE = "price";
        public static final String NAME_COLUMN_OBSERVATIONS = "observations";

        // Every String for every SQL sentence
        // Execute CREATE and DROP
        public static final String SQL_CREATE_TABLE =
                " CREATE TABLE " + NAME_TABLE  + " ( "
                        + _ID + " SERIAL PRIMARY KEY, "
                        + NAME_COLUMN_NAME + " varchar(15), "
                        + NAME_COLUMN_PHOTO + " blob, "
                        + NAME_COLUMN_DAY + " date, "
                        + NAME_COLUMN_HOUR + " time, "
                        + NAME_COLUMN_PRICE + " float, "
                        + NAME_COLUMN_OBSERVATIONS +  " text);";


        public final String SQL_DROP_TABLE = " DROP TABLE IF EXISTS " + NAME_TABLE;

    }

    public static class User_Events implements BaseColumns {
        // One string for column
        // To implements BaseColumns, column _ID appears

        public static final String NAME_TABLE = "User_Events";
        public static final String NAME_COLUMN_EVENT_ID = "eventId";
        public static final String NAME_COLUMN_USER_ID = "userId";


        // Every String for every SQL sentence
        // Execute CREATE and DROP
        public static final String SQL_CREATE_TABLE =
                " CREATE TABLE " + NAME_TABLE  + " ( "
                        + NAME_COLUMN_EVENT_ID + " integer REFERENCES event, "
                        + NAME_COLUMN_USER_ID + " integer REFERENCES UserInfo);";


        public final String SQL_DROP_TABLE = " DROP TABLE IF EXISTS " + NAME_TABLE;

    }
}
