package com.example.parth.profirst;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by parth on 19/7/17.
 */

public class DatabaseHelperLect extends SQLiteOpenHelper
{

    public static final String dbname = "lecture_db";
    public static final String tablename1 = "lectures_info";
    public static final String col1 = "ID";
    public static final String col2 = "FacID";



    public static final String admin_create="CREATE TABLE "+ tablename1 +" (ID TEXT ,FacID TEXT);";

    Context on;
    public DatabaseHelperLect(Context context)
    {

        super(context,dbname,null,1);
        on=context;
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(admin_create);
//        ContentValues contentValues = new ContentValues();
//
//        String a=contentValues.getAsString(col2);
//        System.out.println(a);
//        contentValues.put(col1,"24");
//        contentValues.put(col2,"aspff");
//        long result =db.insert(tablename1,null,contentValues);


    }
    public  void insertData(String id,String Factid)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col1,id);
        contentValues.put(col2,Factid);
        long result =db.insert(tablename1,null,contentValues);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+tablename1);
    }

//
}

