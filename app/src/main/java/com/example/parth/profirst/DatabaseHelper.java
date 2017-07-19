package com.example.parth.profirst;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by parth on 19/7/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper
{

    public static final String dbname = "student_db";
    public static final String tablename = "stu_info";

    public static final String col1 = "ID";
    public static final String col2 = "NAME";
    public static final String col3 = "EMAIL";
    public static final String col4 = "CONTACT";

    public  DatabaseHelper(Context context)
    {
        super(context,dbname,null,1);
        SQLiteDatabase db = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ tablename +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,EMAIL TEXT,CONTACT TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+tablename);
    }

    public boolean insertData()//(String c1,String c2,String c3,String c4)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2,"Parth");
        contentValues.put(col3,"parth@shah.com");
        contentValues.put(col4,"8866688666");
        long result =db.insert(tablename,null,contentValues);
        db.close();

        if(result == -1)
            return false;
        else
            return true;
    }

}

