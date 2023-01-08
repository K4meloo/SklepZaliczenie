package com.example.sklepzaliczenie.Data.Source;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class FeedReaderDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    public FeedReaderDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(FeedReaderContract.SQL_CREATE_ENTRIES_USERS);
        sqLiteDatabase.execSQL(FeedReaderContract.SQL_CREATE_ENTRIES_PRODUCTS);
        sqLiteDatabase.execSQL(FeedReaderContract.SQL_CREATE_ENTRIES_ORDERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(FeedReaderContract.SQL_DELETE_ENTRIES_USERS);
        sqLiteDatabase.execSQL(FeedReaderContract.SQL_DELETE_ENTRIES_PRODUCTS);
        sqLiteDatabase.execSQL(FeedReaderContract.SQL_DELETE_ENTRIES_ORDERS);
        onCreate(sqLiteDatabase);
    }
}
