package com.example.parth.profirst;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



/**
 * Created by parth on 19/7/17.
 */

public class AdminLogin extends AppCompatActivity {

    DatabaseHelperAdmin myDb=null;
    SharedPreferences sharedadmin;
    public static final String MyPREFERENCES = "Admin_Session" ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminlogin);
        myDb = new DatabaseHelperAdmin(this);
    }
    public void OnClickAdminLogin(View view)
    {
        EditText t1=(EditText) findViewById(R.id.admin_uname);
        EditText t2=(EditText) findViewById(R.id.admin_pwd);

        Toast toast1=null;
//        boolean bl=myDb.verify(t1.getText().toString(),t2.getText().toString());
        sharedadmin = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        if(true) {

            SharedPreferences.Editor editor = sharedadmin.edit();

            editor.putString("NAME", t1.getText().toString());
            editor.commit();
            Intent a= new Intent(this,AdminProfile.class);
            startActivity(a);

        }
        else {
            toast1 = Toast.makeText(this, "Please check user name or password", Toast.LENGTH_LONG);
            toast1.show();
        }

    }
}

