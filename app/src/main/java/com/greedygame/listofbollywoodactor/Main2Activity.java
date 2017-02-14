package com.greedygame.listofbollywoodactor;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private ArrayAdapter<Integer> adapter;
    Context context;
    ArrayList<Integer> innerArray = new ArrayList<Integer>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main2);
        listView = (ListView) findViewById(R.id.listview);
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, innerArray);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                int itemPosition = position;
                int itemValue = (int) listView.getItemAtPosition(position);
            }
        });
        AsyncTaskRunner task = new AsyncTaskRunner();
        task.execute();
    }

    public class AsyncTaskRunner extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            for (int i = 1; i <= 10000; i++) {
                innerArray.add(i);
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            adapter.notifyDataSetChanged();
        }

        @Override
        protected void onPreExecute() {
            Toast.makeText(Main2Activity.this, "Pre execute",
                    Toast.LENGTH_LONG).show();
        }
    }
}


