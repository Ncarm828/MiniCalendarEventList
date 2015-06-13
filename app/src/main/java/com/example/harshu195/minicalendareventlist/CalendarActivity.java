package com.example.harshu195.minicalendareventlist;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalendarActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        String[] projection = new String[] {
                CalendarContract.Events.CALENDAR_ID, CalendarContract.Events.TITLE, CalendarContract.Events.DESCRIPTION,
                CalendarContract.Events.DTSTART, CalendarContract.Events.DTEND, CalendarContract.Events.ALL_DAY,
                CalendarContract.Events.EVENT_LOCATION };

        Calendar startTime = Calendar.getInstance();
        startTime.set(2015,5,5,0,0);

        Calendar endTime= Calendar.getInstance();
        endTime.set(2015,5,9,0,0);

        // the range is June 5th to June 9

        String selection = "(( " + CalendarContract.Events.DTSTART + " >= " + startTime.getTimeInMillis() + " ) AND" +
                " ( " + CalendarContract.Events.DTSTART + " <= " + endTime.getTimeInMillis() + " ))";

        Cursor cursor = this.getBaseContext().getContentResolver().query( CalendarContract.Events.CONTENT_URI, projection, selection, null, null );

        // output the events
        /*
        // ListView lvEvents = (ListView)findViewById(R.id.lvEvents);
        // CalendarEventsAdapter calendarEventsAdapter = new CalendarEventsAdapter(CalendarActivity.this,cursor);
        // lvEvents.setAdapter(calendarEventsAdapter);
        */

        TextView tvres = (TextView) findViewById(R.id.tvres);
        if (cursor.moveToFirst()) {
            do {
                tvres.append("\n" + "Title: " + " " + cursor.getString(1)+"\n"
                        +"\n" +  " Start-Time: " + " " +  (new Date(cursor.getLong(3))).toString()+"\n"
                        +"\n" +  " End-Time: " + " " +  (new Date(cursor.getLong(4))).toString()+"\n");
            } while ( cursor.moveToNext());
        }
    }
}
