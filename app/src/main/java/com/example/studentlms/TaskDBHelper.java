package com.example.studentlms;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "tasks.db";
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

        String currentDate = getCurrentDate();
        if (!isTaskAlreadyAdded(task.getRollNo(), currentDate)){
            ContentValues values = new ContentValues();


            values.put("sabaq", task.getSabaq());
            values.put("sabaqi", task.getSabaqi());
            values.put("manzil", task.getManzil());

            values.put("rollNo", task.getRollNo());
            values.put("date", currentDate);

            db.insert(TABLE_NAME, null, values);
            db.close();
        }
    }

    public List<Task> selectAllTasks(String rollNo){
        List<Task> tasks = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM tasks WHERE rollNo = ?";
        String[] selectionArgs = {String.valueOf(rollNo)};
        Cursor cursor = db.rawQuery(sql, selectionArgs);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range") String sabaq = cursor.getString(cursor.getColumnIndex(COLUMN_SABAQ));
                @SuppressLint("Range") String sabaqi = cursor.getString(cursor.getColumnIndex(COLUMN_SABAQI));
                @SuppressLint("Range") String manzal = cursor.getString(cursor.getColumnIndex(COLUMN_MANZIL));
                @SuppressLint("Range") String date = cursor.getString(cursor.getColumnIndex(COLUMN_DATE));
                @SuppressLint("Range")  String roll = cursor.getString(cursor.getColumnIndex(COLUMN_ROLLNO));
                tasks.add(new Task(roll, sabaq, sabaqi, manzal, date));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return tasks;
    }

    public boolean isTaskAlreadyAdded(String rollNo, String currentDate) {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM tasks";
        // String[] selectionArgs = {String.valueOf(rollNo), currentDate};
        Cursor cursor = db.rawQuery(query, null);
        boolean taskExists = cursor.getCount() > 0;
        cursor.close();
        return taskExists;
    }
    public String getCurrentDate() {
        // Create a SimpleDateFormat object with the desired date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date currentDate = new Date();

        // Format the current date using the SimpleDateFormat object
        String formattedDate = dateFormat.format(currentDate);

        System.out.println(formattedDate);
        return formattedDate;
    }
}
