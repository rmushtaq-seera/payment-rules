package com.almosafer.paymentrules.utils;

public class CommonUtils {
    public static boolean isNullOrEmptyString(String input){
        return null == input || input.isEmpty();
    }
    public static boolean isNull(Object input){
        return null == input;
    }
}
