package com.example.parth.profirst;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by parth on 19/7/17.
 */

public class AdminLogin extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminlogin);
    }
    public void OnClickAdminLogin(View view)
    {
        Intent a= new Intent(this,AdminProfile.class);
        startActivity(a);
    }
}

