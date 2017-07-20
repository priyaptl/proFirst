package com.example.parth.profirst;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by parth on 19/7/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper
{

    public static final String dbname = "student_db";
    public static final String tablename = "stu_info";
   // public static final String tablename1 = "admin_info";

    public static final String col1 = "ID";
    public static final String col2 = "NAME";
    public static final String col3 = "PASSWORD";
    public static final String col4 = "EMAIL";
    public static final String col5 = "ENNO" ;

    Context on;
    public  DatabaseHelper(Context context)
    {

        super(context,dbname,null,1);
        on=context;
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ tablename +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PASSWORD TEXT,EMAIL TEXT,ENNO TEXT);");
//        db.execSQL("CREATE TABLE "+ tablename1 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PASSWORD TEXT,EMAIL TEXT);");
//        insertAdmin();
    }
//    public  void insertAdmin()
//    {
//        SQLiteDatabase db =this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put(col2,"sunil");
//        contentValues.put(col3,"sunil");
//        contentValues.put(col4,"sunil@patel.com");
//        long result =db.insert(tablename1,null,contentValues);
//
//        contentValues.put(col2,"kirti");
//        contentValues.put(col3,"kirti");
//        contentValues.put(col4,"kirti@tk.com");
//        result =db.insert(tablename1,null,contentValues);
//
//        contentValues.put(col2,"mosin");
//        contentValues.put(col3,"mosin");
//        contentValues.put(col4,"mosin@patel.com");
//        result =db.insert(tablename1,null,contentValues);
//        db.close();
//    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+tablename);
    }

    public boolean insertData(String a,String b,String c,String d)//(String c1,String c2,String c3,String c4)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(col2,a);
        contentValues.put(col5,b);
        contentValues.put(col3,c);
        contentValues.put(col4,d);
        long result =db.insert(tablename,null,contentValues);
        db.close();

        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean verify(String s, String s1)
    {
        Cursor c;
        SQLiteDatabase db =this.getWritableDatabase();
        String SELECT_SQL = "SELECT * FROM "+tablename+" where NAME = '"+s+"' and PASSWORD = '"+s1+"'";

        c = db.rawQuery(SELECT_SQL, null);
        c.moveToFirst();
        int i = c.getCount();
        c.close();
        if(i<=0)
             return false;
        else
            return true;
    }

//    public boolean verifyAdmin(String s, String s1)
//    {
//        Cursor c;
//        SQLiteDatabase db =this.getWritableDatabase();
//        String SELECT_SQL = "SELECT * FROM "+tablename1+" where NAME = '"+s+"' and PASSWORD = '"+s1+"'";
//
//        c = db.rawQuery(SELECT_SQL, null);
//        c.moveToFirst();
//        int i = c.getCount();
//        c.close();
//        if(i<=0)
//            return false;
//        else
//            return true;
//    }
}

