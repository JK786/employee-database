package com.commons;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

//TODO: Write unit tests
@Component
public class DatetimeUtility {

    //NOTE: Help taken online

    /**
     * Convert a date time string to UTC
     * @param dateTimeString
     * @param sourceTimeZoneId
     * @return
     */
    public static Instant convertToUTC(final String dateTimeString,final  String sourceTimeZoneId) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);

        // Convert LocalDateTime to ZonedDateTime with source time zone
        ZoneId sourceZone = ZoneId.of(sourceTimeZoneId);
        LocalDateTime localDateTime = dateTime.atZone(sourceZone).toLocalDateTime();

        // Convert LocalDateTime to Instant in UTC
        Instant utcInstant = localDateTime.atZone(ZoneId.of("UTC")).toInstant();

        return utcInstant;
    }

    /**
     *
     * @param utcInstant
     * @param targetTimeZoneId
     * @return
     */
    public static String convertToTimeZoneString(Instant utcInstant, String targetTimeZoneId) {
        // Convert Instant to LocalDateTime in UTC
        LocalDateTime utcDateTime = LocalDateTime.ofInstant(utcInstant, ZoneId.of("UTC"));

        // Convert LocalDateTime to ZonedDateTime with target time zone
        LocalDateTime localDateTime = utcDateTime.atZone(ZoneId.of(targetTimeZoneId)).toLocalDateTime();

        // Format LocalDateTime to datetime string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTimeString = localDateTime.format(formatter);

        return dateTimeString;
    }



}
