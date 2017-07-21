package com.example.parth.profirst;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.parth.profirst.R;

public class LectureActivity extends AppCompatActivity {

    DatabaseHelperLect MyDb=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture);
        MyDb = new DatabaseHelperLect(this);

        DatabaseHelperAttend dbha = new DatabaseHelperAttend(this);
        Cursor c = dbha.getReadableDatabase().rawQuery("SELECT * FROM attendance_info ", null);
        c.moveToFirst();


        Log.i("Attend DB", String.valueOf(c.getCount()));
        TextView temp=(TextView)findViewById(R.id.textView6);
        temp.setText(c.getString(c.getColumnIndex("ID")));
        temp.setText(c.getString(c.getColumnIndex("LectID")));

        temp=(TextView)findViewById(R.id.textView4);
        temp.setText(c.getString(c.getColumnIndex("ID")));

        temp=(TextView)findViewById(R.id.textView5);
        temp.setText(c.getString(c.getColumnIndex("StudentID")));

        temp=(TextView)findViewById(R.id.textView3);
        temp.setText("ID");

        temp=(TextView)findViewById(R.id.textView2);
        temp.setText("Lecture ID");

        temp=(TextView)findViewById(R.id.textView);
        temp.setText("Studnet ID");

        //while(!c.moveToNext())
        //{
        c.moveToNext();
            temp=(TextView)findViewById(R.id.textView7);
            temp.setText(c.getString(c.getColumnIndex("ID")));

        temp=(TextView)findViewById(R.id.textView8);
        temp.setText(c.getString(c.getColumnIndex("StudentID")));

        temp=(TextView)findViewById(R.id.textView9);
        temp.setText(c.getString(c.getColumnIndex("LectID")));

    }
}
