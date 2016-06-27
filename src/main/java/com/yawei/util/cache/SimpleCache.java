package com.yawei.util.cache;


import java.util.HashMap;
import java.util.Map;

public class SimpleCache {
    private static Map<String, Object> map = new HashMap<>();

    public static void set(String key, Object value) {
        map.put(key, value);
    }

    public static Object get(String key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return null;
    }

    public static void remove(String key){
        map.remove(key);
    }
}
