package com.lboeri.boeriapi.common;

public class Replacement {
    public static String parse(String snippet){
        return snippet;
    }

    public  String parse(int index, int start, int end, String snippet){
        return parse(snippet);
    }

}
