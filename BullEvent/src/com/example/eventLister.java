package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class eventLister extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_lister);

        ListView listView = (ListView) findViewById(R.id.eventlist);
        Spinner spinny = (Spinner) findViewById(R.id.sortSpinner);
        String[] events = new String[] { "Solia Gratia Concert", "USF Men's Soccer vs Rutgers", "Createch Hackathon",
                "Hillel Bagel Brunch", "USF Volleyball vs. Georgetown", "Zombie Apocalyspe at USF Riverfront", "Doctor Wholloween", "Pink Carpet",
                "Cornerstone Christian Church", "American Heart Association Heart Walk" };
        String[] sortTerms = new String[] { "Multicultural", "Sports", "Food", "Tech", "Volunteer", "Recreation",
                "Political", "Religious", "Professional" };

// First paramenter - Context
// Second parameter - Layout for the row
// Third parameter - ID of the TextView to which the data is written
// Forth - the Array of data
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
                R.layout.list_row,R.id.text1, events);
        ArrayAdapter<String> spinnyAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, sortTerms);
        spinny.setAdapter(spinnyAdapter);

// Assign adapter to ListView
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Intent intent = new Intent(eventLister.this, detailedEvent.class);
                startActivity(intent);
            }
        });

    }


}
