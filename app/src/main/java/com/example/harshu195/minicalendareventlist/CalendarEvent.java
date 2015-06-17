package com.example.harshu195.minicalendareventlist;

import android.content.Context;
import android.database.Cursor;
import android.provider.CalendarContract;

import java.util.Calendar;

public class CalendarEvent {
    Context context;
    public CalendarEvent(Context context) {
        this.context = context;
    }

    public String getCalendarEvent(){
        String[] projection = new String[] {
                CalendarContract.Events.CALENDAR_ID, CalendarContract.Events.TITLE, CalendarContract.Events.DESCRIPTION,
                CalendarContract.Events.DTSTART, CalendarContract.Events.DTEND, CalendarContract.Events.ALL_DAY};

        String selection = "(( " + CalendarContract.Events.DTSTART + " >= " + (System.currentTimeMillis() - 24*60*60*1000)  + " ) AND" +
                " ( " + CalendarContract.Events.DTSTART + " <= " + (System.currentTimeMillis() + 1000*60*60*2)  + " ))";

        Cursor cursor = this.context.getContentResolver().query(CalendarContract.Events.CONTENT_URI, projection, selection, null, null);

        String res="";
        Calendar calendar = Calendar.getInstance();
        if (cursor.moveToFirst()) {
            do {
                calendar.setTimeInMillis(cursor.getLong(3));
               res += ("\n" + "Title: " + " " + cursor.getString(1)+"\n"
                        +"\n" +  " Start-Time: " + " " +  cursor.getLong(3)+"\n"
                        +"\n" +  " End-Time: " + " " +  cursor.getLong(4)+"\n"
                        +"\n" + "Hour" +calendar.get(Calendar.HOUR_OF_DAY) + "\n"
                        +"\n" + "Minutes" +calendar.get(Calendar.MINUTE) );
            } while ( cursor.moveToNext());
        return res;
        }
        return "0";
    }
}