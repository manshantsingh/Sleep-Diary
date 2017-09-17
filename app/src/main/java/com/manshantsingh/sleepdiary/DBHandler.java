package com.manshantsingh.sleepdiary;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mansh on 9/16/2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SleepDiary";
    private static final String TABLE_DI = "DailyInfo";

    private static final String KEY_ID="id";
    private static final String KEY_SLEEP_DATE="sleepDate";
    private static final String KEY_BED_IN="bedIn";
    private static final String KEY_SLEEP_TRY="sleepTry";
    private static final String KEY_SLEEP_TIME="sleepTime";
    private static final String KEY_WAKE_TIME="wakeTime";
    private static final String KEY_BED_OUT="bedOut";
    private static final String KEY_NUM_WAKES="numWakes";
    private static final String KEY_SLEEP_RATE="sleepRate";
    private static final String KEY_FEEL_RATE="feelRate";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_DI + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_SLEEP_DATE + " TEXT,"
                + KEY_BED_IN + " TEXT,"
                + KEY_SLEEP_TRY + " TEXT,"
                + KEY_SLEEP_TIME + " TEXT,"
                + KEY_WAKE_TIME + " TEXT,"
                + KEY_BED_OUT + " TEXT,"
                + KEY_NUM_WAKES + " INTEGER,"
                + KEY_SLEEP_RATE + " INTEGER,"
                + KEY_FEEL_RATE + " INTEGER" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DI);
        onCreate(db);
    }

    
}
