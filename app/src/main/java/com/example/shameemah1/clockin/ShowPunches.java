package com.example.shameemah1.clockin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import static com.example.shameemah1.clockin.MainActivity.USERNAME;

/**
 * Created by peter on 12/3/2016.
 */

public class ShowPunches extends AppCompatActivity {

    ListView listView;
    ArrayAdapter listAdapter;

    Intent intent;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_punches);

        intent = this.getIntent();

        user = (User)intent.getSerializableExtra("user");

        listView = (ListView) findViewById(R.id.listView);

        listAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, user.punches);
        listView.setAdapter(listAdapter);

    }
}
