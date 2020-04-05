package com.example.mob_dev3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "resultsDB";
    public static final String TABLE_RESULTS = "results";

    public static final String KEY_ID = "id";
    public static final String KEY_ANSWER = "answer";

    public DBhelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + TABLE_RESULTS + "(" + KEY_ID + " integer primary key,"
                + KEY_ANSWER + " text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table if exists " + TABLE_RESULTS);

        onCreate(db);
    }
}
