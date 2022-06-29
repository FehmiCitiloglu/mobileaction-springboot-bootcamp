package com.fehmi.mobileaction.mobileactionbootcamp.gen.util;

import org.apache.commons.lang3.RandomStringUtils;

public class StringUtil {

    public static String getRandomNumberAsString(int charCount){

        if (charCount <= 0 ) {
            throw new RuntimeException("Char count can not be zero or negative");
        }
        String randomNumeric = RandomStringUtils.randomNumeric(charCount);
        return randomNumeric;
    }

}
