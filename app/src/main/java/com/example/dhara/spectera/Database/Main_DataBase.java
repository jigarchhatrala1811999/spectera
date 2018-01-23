package com.example.dhara.spectera.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dhara on 23-01-2018.
 */

public class Main_DataBase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="spectera";
    public static final String EVENT_TABLE="events";

    public Main_DataBase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table "+EVENT_TABLE+" (no int primary key auto_increment," +
                "event_id varchar(1000),event_name varchar(1000),no_players varchar(100),event_type varchar(1000)," +
                "event_images varchar(3000),e_desc varchar(2000),s_desc varchar(2000),event_time varchar(1000),event_fees varchar(2000)" +
                ",event_rules varchar(3000),win_price varchar(300),type varchar(40));";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
