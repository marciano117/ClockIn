package com.example.shameemah1.clockin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

import static com.example.shameemah1.clockin.MainActivity.USERNAME;

/**
 * Created by emmanuel on 12/3/2016.
 * This code will provide functionallity for normal users
 * From here users will login and logout
 * Also contains a button for sending user to an activity to search for time worked
 */

public class UserActivity2 extends AppCompatActivity{

    String currentDateTimeString;

    Intent intent;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_2nd);

        //get user information from login page
        intent = this.getIntent();
        String username = intent.getStringExtra(USERNAME);
        TextView usernameTitle = (TextView) findViewById(R.id.username);
        usernameTitle.setText(username);

        user = (User)intent.getSerializableExtra("user");
    }

    public void clockIn (View view){
        currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        user.punches.add(currentDateTimeString);
        Toast.makeText(getApplicationContext(), "Clocked in successfully!", Toast.LENGTH_SHORT).show();
    }

    public void clockOut (View view){
        currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        user.punches.add(currentDateTimeString);
        Toast.makeText(getApplicationContext(), "Clocked out successfully!", Toast.LENGTH_SHORT).show();
    }

    public void search (View view){
        Intent searchIntent = new Intent(this, ShowPunches.class);
        searchIntent.putExtra("user", (User)user);
        startActivity(searchIntent);
    }
}
