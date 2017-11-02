package com.manshantsingh.sleepdiary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mansh on 9/16/2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SleepDiary";
    private static final String TABLE_DI = "DailyInfo";

    private static final String KEY_ID = "id";
    private static final String KEY_SLEEP_DATE = "sleepDate";
    private static final String KEY_BED_IN = "bedIn";
    private static final String KEY_SLEEP_TRY = "sleepTry";
    private static final String KEY_SLEEP_TIME = "sleepTime";
    private static final String KEY_WAKE_TIME = "wakeTime";
    private static final String KEY_BED_OUT = "bedOut";
    private static final String KEY_NUM_WAKES = "numWakes";
    private static final String KEY_SLEEP_RATE = "sleepRate";
    private static final String KEY_FEEL_RATE = "feelRate";
    private static final String KEY_NUM_COFFEE = "numCoffee";


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
                + KEY_FEEL_RATE + " INTEGER"
                + KEY_NUM_COFFEE + " INTEGER" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DI);
        onCreate(db);
    }

    public void addDailyInfo(DailyInfo dailyInfo) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_SLEEP_DATE, dailyInfo.getSleepDate());
        values.put(KEY_BED_IN, dailyInfo.getBedIn());
        values.put(KEY_SLEEP_TRY, dailyInfo.getSleepTry());
        values.put(KEY_SLEEP_TIME, dailyInfo.getSleepTime());
        values.put(KEY_WAKE_TIME, dailyInfo.getWakeTime());
        values.put(KEY_BED_OUT, dailyInfo.getBedOut());
        values.put(KEY_NUM_WAKES, dailyInfo.getNumWakes());
        values.put(KEY_SLEEP_RATE, dailyInfo.getSleepRate());
        values.put(KEY_FEEL_RATE, dailyInfo.getFeelRate());
        values.put(KEY_NUM_COFFEE, dailyInfo.getFeelRate());

        db.insert(TABLE_DI, null, values);
        db.close();
    }

    public int updateDailyInfo(DailyInfo dailyInfo) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_SLEEP_DATE, dailyInfo.getSleepDate());
        values.put(KEY_BED_IN, dailyInfo.getBedIn());
        values.put(KEY_SLEEP_TRY, dailyInfo.getSleepTry());
        values.put(KEY_SLEEP_TIME, dailyInfo.getSleepTime());
        values.put(KEY_WAKE_TIME, dailyInfo.getWakeTime());
        values.put(KEY_BED_OUT, dailyInfo.getBedOut());
        values.put(KEY_NUM_WAKES, dailyInfo.getNumWakes());
        values.put(KEY_SLEEP_RATE, dailyInfo.getSleepRate());
        values.put(KEY_FEEL_RATE, dailyInfo.getFeelRate());
        values.put(KEY_NUM_COFFEE, dailyInfo.getFeelRate());

        int retVal = db.update(TABLE_DI, values, KEY_ID + " = ?",
                new String[]{String.valueOf(dailyInfo.getId())});
        db.close();
        return retVal;
    }

    public void deleteDailyInfo(DailyInfo dailyInfo) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_DI, KEY_ID + " = ?",
                new String[]{String.valueOf(dailyInfo.getId())});
        db.close();
    }

    public DailyInfo getDailyInfo(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_DI, null, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor == null)
            return null;

        cursor.moveToFirst();
        DailyInfo dailyInfo = new DailyInfo(cursor.getInt(0),
                cursor.getString(1), cursor.getString(2), cursor.getString(3),
                cursor.getString(4), cursor.getString(5), cursor.getString(6),
                cursor.getInt(7), cursor.getInt(8), cursor.getInt(9),
                cursor.getInt(10));

        cursor.close();
        db.close();
        return dailyInfo;
    }

    public DailyInfo getDailyInfo(String date) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_DI, null, KEY_SLEEP_DATE + "=?",
                new String[]{date}, null, null, null, null);
        if (cursor == null)
            return null;

        cursor.moveToFirst();
        DailyInfo dailyInfo = new DailyInfo(cursor.getInt(0),
                cursor.getString(1), cursor.getString(2), cursor.getString(3),
                cursor.getString(4), cursor.getString(5), cursor.getString(6),
                cursor.getInt(7), cursor.getInt(8), cursor.getInt(9),
                cursor.getInt(10));

        cursor.close();
        db.close();
        return dailyInfo;
    }

    public List<DailyInfo> getAllDailyInfos() {
        List<DailyInfo> dailyInfoList = new ArrayList<DailyInfo>();

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM " + TABLE_DI, null);

        if (cursor.moveToFirst()) {
            do {
                dailyInfoList.add(new DailyInfo(cursor.getInt(0),
                        cursor.getString(1), cursor.getString(2), cursor.getString(3),
                        cursor.getString(4), cursor.getString(5), cursor.getString(6),
                        cursor.getInt(7), cursor.getInt(8), cursor.getInt(9),
                        cursor.getInt(10)));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return dailyInfoList;
    }

    public List<DailyInfo> getDailyInfosInRange(String startDate, String endDate) {
        List<DailyInfo> dailyInfoList = new ArrayList<DailyInfo>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(TABLE_DI, null,
                KEY_SLEEP_DATE + ">=? AND " + KEY_SLEEP_DATE + "<=?",
                new String[]{startDate, endDate}, null, null, null, null);
        if (cursor == null)
            return dailyInfoList;

        if (cursor.moveToFirst()) {
            do {
                dailyInfoList.add(new DailyInfo(cursor.getInt(0),
                        cursor.getString(1), cursor.getString(2), cursor.getString(3),
                        cursor.getString(4), cursor.getString(5), cursor.getString(6),
                        cursor.getInt(7), cursor.getInt(8), cursor.getInt(9),
                        cursor.getInt(10)));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return dailyInfoList;
    }
}
