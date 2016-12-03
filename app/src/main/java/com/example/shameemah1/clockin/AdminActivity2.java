package com.example.shameemah1.clockin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class AdminActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity_2nd);


        //get user information from login page
        Intent intent = getIntent();
        String username = intent.getStringExtra(MainActivity.USERNAME);
        //TextView usernameTitle = (TextView) findViewById(R.id.username);
        //usernameTitle.setText(username);

    }
}