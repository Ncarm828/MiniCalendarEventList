package com.example.harshu195.minicalendareventlist;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.Date;

public class CalendarEventsAdapter extends CursorAdapter {
    public CalendarEventsAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvTittle = (TextView) view.findViewById(R.id.tvTittle);
        TextView tvStime = (TextView)view.findViewById(R.id.tvSTime);
        TextView tvEtime = (TextView) view.findViewById(R.id.tvETime);

        String tittle= cursor.getString(1);
        String stime = (new Date(cursor.getLong(3))).toString();
        String etime = (new Date(cursor.getLong(4))).toString();

        tvTittle.setText(tittle);
        tvStime.setText(stime);
        tvEtime.setText(etime);

    }
}
