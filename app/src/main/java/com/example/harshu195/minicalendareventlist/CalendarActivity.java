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

        //getting a text view to display the result obtained
        TextView tvres = (TextView) findViewById(R.id.tvres);

        //creating a calendarEvent Class obj and making a call to get the result.
        CalendarEvent calendarEvent = new CalendarEvent(this);

        //Assuming each slot is of one hour from the time this function is called

        //Check if the present time slot is available
        if(calendarEvent.isSlotAvailable()){
            //If free print the info with time slot
            tvres.append("\n This Slot is Free \n" +calendarEvent.res);
        }else{
            //If not give the event details
            tvres.append("\n Your this slot event is \n" +calendarEvent.res);
        }
        //Check if the next slot is free
        if(calendarEvent.isNextSlotAvailable()){
            //If free show the info with slot time
            tvres.append("\n Next Slot is Free\n" +calendarEvent.res );
        }else{
            // If not show the next event details
            tvres.append("\n Your next Event is \n" +calendarEvent.res);
        }
    }
}
