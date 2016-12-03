package com.example.shameemah1.clockin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    public final static String USERNAME = "com.example.shameemah1.clockin.MESSAGE";
    EditText loginUsername;
    EditText loginPassword;

    String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

    public User admin = new User(0, "admin", "password", 0);
    public User peter = new User(1, "Peter", "Marciano", 0);
    public User justin = new User(1, "Justin", "Kvedaras", 0);

    String username = "";
    String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //admin.punches.add(currentDateTimeString);
        //System.out.println(admin.punches.get(0));

        /* DATABASE LINES
        SqlHelper db = new SqlHelper(this);
        db.addUser(new User(0, "John", "Doe", 100));    //Level 100 will have admin
        db.addUser(new User(0, "Jane", "Smith", 200));  //Level 200 will NOT have admin
        db.addUser(new User(0, "Michael", "Jordan", 200));  //Level 200 will NOT have admin
        */

        loginUsername = (EditText) findViewById(R.id.username);
        loginPassword = (EditText) findViewById(R.id.password);
    }

    public void loginClick(View view) {
        Intent userIntent = new Intent(this, UserActivity2.class);
        Intent adminIntent = new Intent(this, AdminActivity2.class);
        username = loginUsername.getText().toString();
        password = loginPassword.getText().toString();

        if (admin.getUser().equals(username) && admin.getPass().equals(password)) {
            adminIntent.putExtra(USERNAME, username);
            if (admin.getLevel() == 0) {
                startActivity(adminIntent);
            } else {
                startActivity(userIntent);
            }
        } else if (peter.getUser().equals(username) && peter.getPass().equals(password)) {
            userIntent.putExtra(USERNAME, username);
            if (peter.getLevel() == 0) {
                startActivity(adminIntent);
            } else {
                startActivity(userIntent);
            }
        } else if (justin.getUser().equals(username) && justin.getPass().equals(password)) {
            userIntent.putExtra(USERNAME, username);
            if (justin.getLevel() == 0) {
                startActivity(adminIntent);
            } else {
                startActivity(userIntent);
            }
        } else {
            Toast.makeText(getApplicationContext(), "Login Failed!", Toast.LENGTH_SHORT).show();
            //Login Failed
        }
    }
}
