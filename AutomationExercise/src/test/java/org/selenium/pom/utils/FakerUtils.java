package org.selenium.pom.utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FakerUtils {


    public static Long generateRandomNumber(){
        Faker faker = new Faker();
        return faker.number().randomNumber();
    }


    public static int extractIntegerPart(String input) {
        // Use a regular expression to find the digits in the string
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            // Convert the matched digits to an integer
            return Integer.parseInt(matcher.group());
        } else {
            // Handle the case where no digits are found
            throw new IllegalArgumentException("No integer part found in the input string");
        }
    }


    }
