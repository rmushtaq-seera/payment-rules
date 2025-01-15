package com.almosafer.paymentrules.utils;

import java.util.Collection;

public class CommonUtils {
    public static boolean isNullOrEmptyString(String input){
        return null == input || input.isEmpty();
    }
    public static boolean isNull(Object input){
        return null == input;
    }
    public static boolean isNullOrEmpty(Collection<?> input) {
        return input == null || input.isEmpty();
    }

}
