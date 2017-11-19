package com.example.macbook.labexam2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by macbook on 11/19/2017 AD.
 */

public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "memberDB.db";
    public static final String TABLE_NAME = "members";
    public static final String COLUMN_MEMBER_ID = "member_id";
    public static final String COLUMN_FIRST_NAME = "first_name";
    public static final String COLUMN_LAST_NAME = "last_name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONE_NO = "phone_no";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_MOVIE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(DROP_MOVIE_TABLE);
        onCreate(db);
    }

    public Cursor getMemberbyID(int id) {
        String SQL = "SELECT * FROM " + TABLE_NAME +
                " WHERE " + COLUMN_MEMBER_ID + " = " + id;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor resultSet = db.rawQuery(SQL, null);
        return resultSet;
    }

}
