package com.example.shameemah1.clockin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends AppCompatActivity {

    EditText loginUsername;
    EditText loginPassword;

    private String name1 = "admin";
    private String name2 = "Peter";
    private String name3 = "Justin";
    private String pass1 = "password";
    private String pass2 = "Marciano";
    private String pass3 = "Kvedaras";

    String username = "";
    String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SqlHelper db = new SqlHelper(this);

        /* ADD USERS LATER
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

        if (name1.equals(username) && pass1.equals(password)) {
            adminIntent.putExtra("username", username);
            startActivity(adminIntent);
        } else if (name2.equals(username) && pass2.equals(password)) {
            userIntent.putExtra("username", username);
            startActivity(userIntent);
        } else if (name3.equals(username) && pass2.equals(password)) {
            userIntent.putExtra("username", username);
            startActivity(userIntent);
        } else {
            Toast.makeText(getApplicationContext(), "Login Failed!", Toast.LENGTH_SHORT).show();
            //Login Failed
        }
    }
}
