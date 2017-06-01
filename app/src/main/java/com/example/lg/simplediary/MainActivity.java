package com.example.lg.simplediary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
        String diaryStr=null;
        FileInputStream fin=null;
        try {
              fin = openFileInput(fileName);
            byte[] buf= new byte[500];
            fin.read(buf); //예외처리가 되어야한다
            diaryStr=new String(buf).trim(); //trim 앞 뒤 공백을 제거해쥼~
            but.setText("수정");
        }catch (FileNotFoundException e){ //파일이 존재하지 않을 때
            edit.setText("일기가 존재하지 않습니다. ");
            but.setText("새로 저장");
        } catch(IOException e){

        }
        return diaryStr;
    }
}