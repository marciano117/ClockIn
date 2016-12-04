package com.example.shameemah1.clockin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

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

        TextView usernameTitle = (TextView) findViewById(R.id.showPunchUsername);
        usernameTitle.setText(user.getUser());

        TextView hoursTitle = (TextView) findViewById(R.id.showPunchHours);
        hoursTitle.setText(user.getHours());

        TextView minutesTitle = (TextView) findViewById(R.id.showPunchMinutes);
        minutesTitle.setText(user.getMinutes());

        ArrayList<CharSequence> arr = new ArrayList<CharSequence>();
        System.out.println(arr.size());
        for (int i=0; i<user.punches.size(); i++) {
            System.out.println(user.punches.get(i));
            arr.add(DateFormat.format("HH:mm:ss", user.punches.get(i)));
        }

        listAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr);
        listView.setAdapter(listAdapter);
    }
}
