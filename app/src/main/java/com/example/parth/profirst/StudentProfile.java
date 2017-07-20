package com.example.parth.profirst;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class StudentProfile extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentprofile);

    }

    public void onClickMyQr(View view){
        Intent a = new Intent(StudentProfile.this , MainActivity.class);
        startActivity(a);
    }

    public void onClickDetails(View view){
        Intent a = new Intent(StudentProfile.this , StudentDetails.class);
        startActivity(a);
    }
}