package com.qa.utils;

public class DynamicXpath {


    public static String getXpath(String keyword){
        return "//span[normalize-space()='replace']"
                .replace("replace",keyword);
    }
}
