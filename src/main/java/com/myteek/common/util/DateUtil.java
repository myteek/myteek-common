package com.myteek.common.util;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

@Slf4j
public class DateUtil {

    private static final String DATE_STRING = "yyyy-MM-dd";

    private static final String DATE_TIME_STRING = "yyyy-MM-dd HH:mm:ss";

    private static final ZoneId zoneId = ZoneId.of("+8");

    public static String formatterDate(Instant instant, DateTimeFormatter dateTimeFormatter) {
        return formatter(LocalDate.ofInstant(instant, zoneId), dateTimeFormatter);
    }

    public static String formatterDate(long millis) {
        return formatterDate(Instant.ofEpochMilli(millis), DateTimeFormatter.ofPattern(DATE_STRING));
    }

    public static String formatterDate(Date date) {
        return formatter(date, DateTimeFormatter.ofPattern(DATE_STRING));
    }

    public static String formatter(Date date, DateTimeFormatter dateTimeFormatter) {
        return formatter(LocalDate.ofInstant(Instant.ofEpochMilli(date.getTime()), zoneId), dateTimeFormatter);
    }

    public static String formatter(LocalDate localDate, DateTimeFormatter dateTimeFormatter) {
        return localDate.format(dateTimeFormatter);
    }

    public static String formatter(LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        return localDateTime.format(dateTimeFormatter);
    }

    public static String formatterDateTime(Instant instant, DateTimeFormatter dateTimeFormatter) {
        return formatter(LocalDateTime.ofInstant(instant, zoneId), dateTimeFormatter);
    }

    public static String formatterDateTime(Date date) {
        return formatter(date, DateTimeFormatter.ofPattern(DATE_TIME_STRING));
    }

    public static String formatterDateTime(long millis) {
        return formatterDateTime(Instant.ofEpochMilli(millis), DateTimeFormatter.ofPattern(DATE_STRING));
    }

    public static long stringToTimestamp(String datetime, String format) {
        return stringToTimestamp(datetime, DateTimeFormatter.ofPattern(format));
    }

    public static long stringToTimestamp(String datetime, DateTimeFormatter dateTimeFormatter) {
        return LocalDateTime.parse(datetime, dateTimeFormatter).atZone(zoneId).toEpochSecond();
    }

    public static long dateToTimestamp(String datetime) {
        return stringToTimestamp(datetime, DateTimeFormatter.ofPattern(DATE_STRING));
    }

    public static long dateTimeToTimestamp(String datetime) {
        return stringToTimestamp(datetime, DateTimeFormatter.ofPattern(DATE_TIME_STRING));
    }

    public static int dayHour(long millis) {
        return Instant.ofEpochMilli(millis).atZone(zoneId).getHour();
    }

    public static Integer getDayOfWeek(String date) {
        return LocalDate.parse(date).getDayOfWeek().getValue();
    }

    public static Integer getDayOfWeek(long milli) {
        return Instant.ofEpochMilli(milli).atZone(zoneId).getDayOfWeek().getValue();
    }

    /**
     * string day to epoch millis
     * @param date
     * @return
     */
    public static Long dateEpochMilli(String date) {
        if (Objects.nonNull(date)) {
            try {
                return LocalDate.parse(date).atStartOfDay(zoneId).toEpochSecond() * 1000L;
            } catch (Exception e) {
                log.warn("parse date error, date: {}", date);
            }
        }
        return 0L;
    }

    public static long startOfDayDate(long milli) {
        return dateEpochMilli(formatterDate(milli));
    }

}
