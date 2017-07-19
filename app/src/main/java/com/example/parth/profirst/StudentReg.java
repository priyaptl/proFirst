package com.example.parth.profirst;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by parth on 19/7/17.
 */

public class StudentReg extends AppCompatActivity
{

    public static final String dbname = "student_db";
    public static final String tablename = "stu_info";

    public static final String col1 = "ID";
    public static final String col2 = "NAME";
    public static final String col3 = "EMAIL";
    public static final String col4 = "CONTACT";

       protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentreg);



    }
    public void OnClickDBInsert(View view)
    {

        DatabaseHelper dbh=new DatabaseHelper(this);
        EditText editText=(EditText)findViewById(R.id.editName) ;
        String a = editText.getText().toString();
        editText = (EditText)findViewById(R.id.editEn) ;
        String b = editText.getText().toString();
        editText = (EditText)findViewById(R.id.editemail) ;
        String c = editText.getText().toString();
        editText = (EditText)findViewById(R.id.editcon) ;
        String d = editText.getText().toString();
        boolean bl=dbh.insertData(a,b,c,d);


        Toast toast;
        toast = Toast.makeText(this,"Success.....",Toast.LENGTH_LONG);
        if (bl)
        {
            toast = Toast.makeText(this,"Success",Toast.LENGTH_LONG);
        }
        else
            toast = Toast.makeText(this,"UnSuccessfull",Toast.LENGTH_LONG);
        toast.show();
    }


}
