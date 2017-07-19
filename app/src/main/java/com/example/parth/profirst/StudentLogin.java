package com.example.parth.profirst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StudentLogin extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        DatabaseHelper myDb = new DatabaseHelper(this);
        boolean var= myDb.insertData();
        TextView t1= (TextView) findViewById(R.id.reg);
        t1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent a = new Intent(StudentLogin.this , StudentReg.class);

        startActivity(a);
    }

    public void onClickStuLogin(View view){
        Intent a = new Intent(StudentLogin.this , StudentProfile.class);
        startActivity(a);
    }
}
