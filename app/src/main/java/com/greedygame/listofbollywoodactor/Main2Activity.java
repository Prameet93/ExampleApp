package com.greedygame.listofbollywoodactor;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.id.list;

public class Main2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}
public class AsyncTaskRunner extends AsyncTask<String, String, String> {

    private String resp;
    ProgressDialog progressDialog;
    ListView listView;
    private ArrayAdapter<Integer> adapter;
    ArrayList<Integer> innerArray = new ArrayList<Integer>();

    @Override
    protected String doInBackground(String... params) {
        publishProgress("Sleeping..."); // Calls onProgressUpdate()
        try {
            int time = Integer.parseInt(params[0])*1000;
            for (int i = 1; i <= 10000; i++){
                innerArray.add(i);
            }

            Thread.sleep(time);
            resp = "Slept for " + params[0] + " seconds";
        } catch (InterruptedException e) {
            e.printStackTrace();
            resp = e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            resp = e.getMessage();
        }
        return resp;
    }
    @Override
    protected void onPostExecute(String result) {
        // execution of result of Long time consuming operation

        ArrayList<Integer> innerArray = new ArrayList<Integer>();
        ArrayAdapter<Integer> adapter;
        listView = (ListView) findViewById(R.id.listview);
        adapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, innerArray);

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


    @Override
    protected void onPreExecute() {
        progressDialog = ProgressDialog.show(Main2Activity.this,
                "ProgressDialog",
                "Wait for "+time.getText().toString()+ " seconds");
    }


    @Override
    protected void onProgressUpdate(String... text) {
        finalResult.setText(text[0]);

    }
}
}