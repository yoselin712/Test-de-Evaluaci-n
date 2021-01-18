package com.aedo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidades {

    public static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    public static final String PASSWORD_REGEX = "^(([a-z]*[\\d][a-z]*){2}([a-z]*[A-Z]{1}[a-z]*))$|^(([a-z]*[A-Z]{1}[a-z]*)([a-z]*[\\d][a-z]*){2})$|^(([a-z]*[\\d][a-z]*)([a-z]*[A-Z]{1}[a-z]*)([a-z]*[\\d][a-z]*))$";


    public static boolean validarInput(String inputValue, String regexPattern){
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(inputValue);
        boolean matchFound = matcher.find();
        return matchFound;
    }

}
