package com.example.harshu195.minicalendareventlist;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.widget.TextView;

import java.util.Calendar;

public class CalendarActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        TextView tvres = (TextView) findViewById(R.id.tvres);
        CalendarEvent calendarEvent = new CalendarEvent(this);
        tvres.append(calendarEvent.getCalendarEvent());
    }
}
