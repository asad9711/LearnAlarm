package com.example.asad.learnalarm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Asad on 03-04-2016.
 */
public class AlarmReceiver extends AppCompatActivity
{
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_layout);
        Log.d("asd","writing textview");
        MainActivity.count++;
        tv=(TextView)findViewById(R.id.textview);
        tv.setText("called");
//        if(MainActivity.count==2)
//            System.exit(0);
    }


}
