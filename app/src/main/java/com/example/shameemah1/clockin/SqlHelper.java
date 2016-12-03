package com.example.shameemah1.clockin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.List;

public class SqlHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "FinalProject";
    // USERS table name
    private static final String TABLE_USERS = "users";
    // Books Table Columns names
    private static final String KEY_ID = "_id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASS = "password";
    private static final String KEY_LEVEL = "level";

    public SqlHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
// SQL statement to create book table
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USERS + "( " +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_USERNAME + " TEXT, " +
                KEY_PASS + " TEXT, " + KEY_LEVEL + " NUMBER );";

// create books table
        db.execSQL(CREATE_USER_TABLE);
        Log.d("Created Table", "Created Table" + TABLE_USERS);
        //db.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// create fresh books table
        this.onCreate(db);
    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
// 2. create ContentValues to add key "column"/value

        ContentValues values = new ContentValues();
        values.put(KEY_ID, user.getId()); // get user's ID
        values.put(KEY_USERNAME, user.getUser()); // get user name
        values.put(KEY_PASS, user.getPass()); // get password
        values.put(KEY_LEVEL, user.getLevel());     //get level of user
// 3. insert
        db.insert(TABLE_USERS, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/values

// 4.
        userTable(user);
// 4. Close dbase
        db.close();
    }

    public void userTable(User user) {      //this class will create a table for each new user
        SQLiteDatabase db = this.getWritableDatabase();
        final int KEY_UID= user.getId();
        final String KEY_USER = user.getUser();

        String CREATE_INDIVIDUAL_TABLE = "CREATE TABLE " + KEY_USER + " ( " +
                KEY_UID + " INTEGER PRIMARY KEY AUTO_INCREMENT, " + KEY_USER + " TEXT, " +
                "Punch In LONG, Punch Out LONG";      //Timestamp saved as a long


// create table for each user
        db.execSQL(CREATE_INDIVIDUAL_TABLE);
        Log.d("Created Table", "Created Table" + KEY_USER);
        db.close();
    }

//----------------------------
/*CRUD operations (create "add", read "get", update, delete) */
    public void punchIn(User user, Long time){    //I don't know what object we'll use, so I passed time


// 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
// 2. create ContentValues to add key "column"/value

        ContentValues values = new ContentValues();
        values.put(Integer.toString(user.getId()), user.getId()); // get user's ID
        values.put(Integer.toString(user.getLevel()), user.getLevel()); // get level.  Level will determine what functionality
                                                    //the user has (admin vs regular user)
        values.put("Punch In", time);   //adds the punch in time
        values.put("Punch Out", 0);  //this method is only for punch in so nothing will be in punch out
// 3. insert
        db.insert(user.getUser(), // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/values
// 4. Close dbase
        db.close();
    }

    //----------------------------
/*CRUD operations (create "add", read "get", update, delete) */
    public void punchOut(User user, Long time){    //I don't know what object we'll use, so I passed time

// 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
// 2. create ContentValues to add key "column"/value

        ContentValues values = new ContentValues();
        values.put(Integer.toString(user.getId()), user.getId()); // get user's ID
        values.put(Integer.toString(user.getLevel()), user.getLevel()); // get level.  Level will determine what functionality
        //the user has (admin vs regular user)
        values.put("Punch In", 0);   //this method is only for punch out so nothing will be in punch out
        values.put("Punch Out", time);  //add the punch out time
// 3. insert
        db.insert(user.getUser(), // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/values
// 4. Close dbase
        db.close();
    }


}