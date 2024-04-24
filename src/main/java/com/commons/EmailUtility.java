package com.commons;

import org.springframework.stereotype.Component;

//TODO : Write unit tests
@Component
public class EmailUtility {

    public static boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    }

}
