package io.github.bonigarcia.wdm.test.utils;

import org.apache.commons.lang.RandomStringUtils;

public class UsernameGenerator {
    public static String generateUsername(){
        return RandomStringUtils.randomAlphabetic(8);
    }
}
