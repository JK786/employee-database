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
}
