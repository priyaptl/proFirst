package com.example.parth.profirst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AdminProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);

    }
    public void OnClickQr(View view)
    {
        Intent a = new Intent(this,QrMainActivity.class);
        startActivity(a);
    }
}
