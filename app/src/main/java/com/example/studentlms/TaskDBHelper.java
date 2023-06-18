package com.example.studentlms;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

public class TaskDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "students.db";
    private static final String TABLE_NAME = "tasks";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_ROLLNO = "rollNo";
    private static final String COLUMN_SABAQ = "sabaq";
    private static final String COLUMN_SABAQI = "sabaqi";
    private static final String COLUMN_MANZIL = "manzil";
    private static final String COLUMN_DATE = "date";
    private static final Integer DATABASE_VERSION = 1;

    TaskDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_ROLLNO + " TEXT, "
                + COLUMN_SABAQ + " TEXT, "
                + COLUMN_SABAQI + " TEXT, "
                + COLUMN_MANZIL + " TEXT, "
                + COLUMN_DATE + " DATE"
                + ");"
                ;
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public void insertTask(Task task){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("sabaq", task.getSabaq());
        values.put("sabaqi", task.getSabaqi());
        values.put("manzil", task.getManzil());

        values.put("rollNo", task.getRollNo());
        values.put("date", task.getDate().toString());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
}
