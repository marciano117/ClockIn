package com.example.shameemah1.clockin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/**
 * Created by emmanuel on 12/3/2016.
 * This code will provide functionallity for normal users
 * From here users will login and logout
 * Also contains a button for sending user to an activity to search for time worked
 */

public class UserActivity2 extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_2nd);

        //get user information from login page
        Intent intent = getIntent();
        String username = intent.getStringExtra(MainActivity.USERNAME);
        TextView usernameTitle = (TextView) findViewById(R.id.username);
        usernameTitle.setText(username);

        //
    }
    public void clockIn (View view){
        //event listener.
        //Code to execute when user clocks in

    }
    public void clockOut (View view){
        //event listener
        //code to execute when user clocks out
    }
    public void search (View view){
        //sends user to search activity to go through hours worked

    }

}
