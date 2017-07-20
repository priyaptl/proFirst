package com.example.parth.profirst;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class StudentLogin extends AppCompatActivity implements View.OnClickListener{

    DatabaseHelper myDb=null;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "Stu_Session" ;
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
        EditText t1=(EditText) findViewById(R.id.stuname);
        EditText t2=(EditText) findViewById(R.id.stupwd);

        Toast toast1=null;
        boolean bl=myDb.verify(t1.getText().toString(),t2.getText().toString());
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        if(bl) {

            SharedPreferences.Editor editor = sharedpreferences.edit();

            editor.putString("NAME", t1.getText().toString());
            editor.commit();
            Intent a = new Intent(StudentLogin.this, StudentProfile.class);
            startActivity(a);
        }
        else {
            toast1 = Toast.makeText(this, "Please check user name or password", Toast.LENGTH_LONG);
            toast1.show();
        }
    }
}
