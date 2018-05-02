package com.theshatz.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

import static com.theshatz.timestables.R.id.seekBarTime;
import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    ListView myListView;

    public void generateTimesTable(int timesTable){

        ArrayList<String> numbers = new ArrayList<String>();
        //first show of table
        for(int i=1;i<=13;i++){
            numbers.add(Integer.toString(i*timesTable));
        }
        //Array Adapter
        ArrayAdapter arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1,numbers);

        myListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Variables
        SeekBar mySeekBar = (SeekBar)findViewById(seekBarTime);
        myListView = (ListView)findViewById(R.id.timeTableListView);

        //SeekBar info
        mySeekBar.setMax(20);
        mySeekBar.setProgress(1);
        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //use this one because it keeps track of when changed
                int min =1;
                int timesTable;

                if (progress < min){
                    timesTable=min;
                    //keeps greater than 1
                    seekBar.setProgress(min);
                }
                else{
                    timesTable = progress;
                }
                //temp to show seekbar value.
                //Format is Log.i(_____________,______________);
                generateTimesTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generateTimesTable(1);




    }
}
