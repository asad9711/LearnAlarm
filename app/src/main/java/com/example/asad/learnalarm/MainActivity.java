package com.example.asad.learnalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;static int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmMgr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        alarmIntent = PendingIntent.getActivity(this, 0, intent,0);
        Log.d("asd","initialized alarmintent");
//        alarmMgr.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
//                SystemClock.elapsedRealtime() + 10 * 1000, alarmIntent);
        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP,
                SystemClock.elapsedRealtime(),10000, alarmIntent);
//        alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
//                AlarmManager.INTERVAL_,
//                AlarmManager.INTERVAL_HALF_HOUR, alarmIntent);
                        Log.d("asd", "alarm set");

    }
    @Override
    protected void onStop() {
        super.onStop();
        alarmMgr.cancel(alarmIntent);
    }
}
