package com.wangxin.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DateUtil {
    private static volatile Map<String, SimpleDateFormat> dateFormatMap = new ConcurrentHashMap<String, SimpleDateFormat>();

    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat dateFormat = getDateFormat(pattern);

        return dateFormat.format(date);
    }

    public static Date parseDate(String date, String pattern) throws ParseException {
        SimpleDateFormat dateFormat = getDateFormat(pattern);

        return dateFormat.parse(date);
    }

    private static SimpleDateFormat getDateFormat(String pattern) {
        SimpleDateFormat dateFormat = dateFormatMap.get(pattern);
        if (dateFormat == null) {
            SimpleDateFormat newDateFormat = new SimpleDateFormat();
            newDateFormat.applyPattern(pattern);
            dateFormat = dateFormatMap.putIfAbsent(pattern, newDateFormat);
            if (dateFormat == null) {
                dateFormat = newDateFormat;
            }
        }

        return dateFormat;
    }
}