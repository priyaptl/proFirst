package com.example.parth.profirst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        ImageView stu= (ImageView)findViewById(R.id.imageView3);
        ImageView admin= (ImageView)findViewById(R.id.imageView);

    }
    public void OnClickStu(View view)
    {
        Intent a = new Intent(this, StudentLogin.class);
        startActivity(a);
    }
    public void OnClickAdmin(View view)
    {
        Intent a = new Intent(this, AdminLogin.class);
        startActivity(a);
    }
}
