package com.greedygame.listofbollywoodactor;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private FloatingActionButton fab;
    ArrayList<String> Toppaidactors = new ArrayList<String>();{

        Toppaidactors.add("Aamir");
        Toppaidactors.add("Salman");
        Toppaidactors.add("Shahrukh");
        Toppaidactors.add("Ajay");
        Toppaidactors.add("Akshay");
        Toppaidactors.add("Ranveer");
        Toppaidactors.add("Siddhartha");
        Toppaidactors.add("Varun");
        Toppaidactors.add("Arjun Kapoor");
    }
    ArrayList<String> Actress = new ArrayList<String>();{
            Actress.add("Kareena");
            Actress.add("Katrina");
            Actress.add("Deepika");
            Actress.add("Sonam");
            Actress.add("Sonakshi");
            Actress.add("Alia");
    }
    private ArrayAdapter<String> adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get a random number from the size of Actress
                int id = new Random().nextInt(Actress.size());
                // Get the element from Actress
                String random = Actress.get(id);
                // Add random string into Toppaidactors

                if(Toppaidactors.contains(random)) {
                    Toast.makeText(MainActivity.this, "Already added",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    Toppaidactors.add(0, random);
                    adapter.notifyDataSetChanged();
                }
            }
        });
        listView = (ListView) findViewById(R.id.listview);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, Toppaidactors);

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





