package org.acoe.com.practice;

import java.util.HashMap;
import java.util.Map;

public class Runner {

    private static String a = "Testing mini bytes";
    private static final Map<String, String> map = new HashMap<>();

    static {
        map.put("channel", "TMB");
    }

    static {
        a = "Amuthan";
        map.put("author", "Amuthan");
    }

    public static void main(String[] args) {
        System.out.println(a);
        System.out.println(map);
    }
}
