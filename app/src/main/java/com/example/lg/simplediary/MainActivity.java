package com.example.lg.simplediary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker date;
    EditText edit;
    Button but;
    String fileName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date = (DatePicker)findViewById(R.id.date_pick);
        edit = (EditText)findViewById(R.id.edit);
        but = (Button)findViewById(R.id.but);

        Calendar cal=Calendar.getInstance(); //calendar java.util 로 선택!!!!!!
        int year=cal.get(Calendar.YEAR);
        final int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DATE); //Day of month 도 있음

        date.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName=year+"_"+(monthOfYear+1)+"_"+dayOfMonth+".txt";
                String readData=readDiary(fileName);
                edit.setText(readData);
                but.setEnabled(true);
            }
        });
    }
    public String readDiary(String fileName){
        return null;
    }
}
