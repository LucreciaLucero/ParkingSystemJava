package com.example.parkingsystemjava.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {

    private static String pattern = "yyyy-MM-dd";
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    public static String formatDateToString(Calendar calendar) {
        return simpleDateFormat.format(calendar.getTime());
    }
}
