package com.example.parth.profirst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class StudentLogin extends AppCompatActivity implements View.OnClickListener{

    DatabaseHelper myDb=null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        myDb = new DatabaseHelper(this);


        TextView t1= (TextView) findViewById(R.id.reg);
        t1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent a = new Intent(StudentLogin.this , StudentReg.class);
        a.putExtra("data",myDb.getClass());

        startActivity(a);
    }

    public void onClickStuLogin(View view){
        Intent a = new Intent(StudentLogin.this , StudentProfile.class);
        startActivity(a);
    }
}
