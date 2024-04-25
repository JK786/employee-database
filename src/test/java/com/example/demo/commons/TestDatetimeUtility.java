package com.example.demo.commons;

import com.demo.commons.DatetimeUtility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.Instant;



@RunWith(MockitoJUnitRunner.class)
public class TestDatetimeUtility {

    @InjectMocks
    private DatetimeUtility datetimeUtility;

    @Test
    public void testConvertToUTC() {

        Instant a = DatetimeUtility.convertToUTC("2024-01-01 00:00:00", "Asia/Kolkata");
        int b = 0;
        b = b + 10;
    }
}
