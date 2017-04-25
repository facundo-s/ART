package com.example.art.art;

import android.graphics.PorterDuff;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Jacob on 4/25/2017.
 */

public class Utils {
    public static Date getTomorrow() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 1);
        return c.getTime();
    }
    public static Date getDate(DatePicker datePicker, TimePicker timePicker){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year =  datePicker.getYear();
        int hour = timePicker.getCurrentHour();
        int minute = timePicker.getCurrentMinute();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, minute);

        return calendar.getTime();
    }
    public static String formatDate(Date d) {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy 'at' h:mm a");
        return dateFormat.format(d);
    }

    final static int COLOR_BLUE = 0xff33b5e5,
            COLOR_GREY = 0xFFD6D7D7;
    public static void setButtonState(Button btn, boolean highlight) {
        btn.getBackground().setColorFilter(highlight ? COLOR_BLUE : COLOR_GREY, PorterDuff.Mode.MULTIPLY);
    }

    public static String joinStr(List<String> list, String joiner) {
        String result = "";
        for (int i = 0; i < list.size() - 1; i++) {
            result += list.get(i) + joiner;
        }
        if (list.size() > 0) {
            result += list.get(list.size() - 1);
        }
        return result;
    }
}
