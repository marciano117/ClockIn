package com.example.shameemah1.clockin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private String name1 = "admin";
    private String name2 = "Peter";
    private String name3 = "Justin";
    private String pass1 = "password";
    private String pass2 = "Marciano";
    private String pass3 = "Kvedaras";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText loginUsername = (EditText) findViewById(R.id.username);
        EditText loginPassword = (EditText) findViewById(R.id.password);

    }
}
