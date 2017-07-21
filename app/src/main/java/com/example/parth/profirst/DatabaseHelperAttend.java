package com.example.parth.profirst;


import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by parth on 19/7/17.
 */

public class DatabaseHelperAttend extends SQLiteOpenHelper
{

    public static final String dbname = "attendance_db";
    public static final String tablename1 = "attendance_info";
    public static final String col1 = "ID";
    public static final String col3 = "LectID";
    public static final String col2 = "StudentID";



    public static final String admin_create="CREATE TABLE "+ tablename1 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,LectID TEXT,StudentID TEXT);";

    Context on;
    public DatabaseHelperAttend(Context context)
    {

        super(context,dbname,null,1);
        on=context;
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(admin_create);
        /*ContentValues contentValues = new ContentValues();

        //System.out.println(a);

        //String a=contentValues.getAsString(col2);
        contentValues.put(col2,1);
        t2.setText(c.getString(c.getColumnIndex("ENNO")));
        long result =db.insert(tablename1,null,contentValues);*/


    }
    public  boolean insertAttend(String qr,String enno) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(col2, qr);
        contentValues.put(col3, enno);

        long result = db.insert(tablename1, null, contentValues);
        db.close();

        if (result == -1)
            return false;
        else
            return true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+tablename1);
    }

//
}

