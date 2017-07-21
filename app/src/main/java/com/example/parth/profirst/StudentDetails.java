package com.example.parth.profirst;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StudentDetails  extends AppCompatActivity {

    DatabaseHelper myDb=null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentdetails);

        myDb = new DatabaseHelper(this);

        TextView t1=(TextView) findViewById(R.id.textView12);
        TextView t2=(TextView) findViewById(R.id.textView14);
        TextView t3=(TextView) findViewById(R.id.textView16);


        String s="testname";
        Toast toast1;
        SharedPreferences sharedpreferences = getSharedPreferences(StudentLogin.MyPREFERENCES, Context.MODE_PRIVATE);
        String name=sharedpreferences.getString("NAME",s);

        Cursor c = myDb.getReadableDatabase().rawQuery("SELECT * FROM stu_info WHERE name = '"+name+"'", null);
        c.moveToNext();

        t1.setText(name);
        t2.setText(c.getString(c.getColumnIndex("ENNO")));
        t3.setText(c.getString(c.getColumnIndex("EMAIL")));


    }
}
