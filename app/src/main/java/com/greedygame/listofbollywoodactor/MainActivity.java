package com.greedygame.listofbollywoodactor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        String[] values = new String[] { "Amitabh Bachhan",
                "Salman Khan",
                "Shah Rukh Khan",
                "Akshay Kumar",
                "Ajay Devgan",
                "Ranvir Kapoor",
                "Arjun Kapoor",
                "Siddhartha Malhotra",
                "Varun Dhawan",
                "Saif Ali Khan",
                "Hritik Roushan",
                "Tiger Shroff",
                "Sushant Singh Rajput",
                "Dharmendra",
                "Rajesh Khanna"


        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                int itemPosition = position;
                String itemValue = (String) listView.getItemAtPosition(position);
            }
        });
    }
}


