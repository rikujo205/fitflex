package com.FitFlex.app.utils;

import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract;

public class CalendarUtils {

    public static void addWorkoutReminder(Context context, String title, long startTimeMillis) {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setData(CalendarContract.Events.CONTENT_URI);
        intent.putExtra(CalendarContract.Events.TITLE, title);
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Gym / Home");
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTimeMillis);
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, startTimeMillis + 60 * 60 * 1000); // 1 hour
        intent.putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY);
        context.startActivity(intent);
    }
}
