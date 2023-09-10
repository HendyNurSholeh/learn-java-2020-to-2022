package com.tutorial;

import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
        public static void main(String[] args) {
            SortedMap<Integer, String> map = new TreeMap<>();
            map.put(121334, "Andini");
            map.put(562845, "Surya");
            map.put(334556, "Dwi");
            map.put(782685, "Indri");
            map.put(247554, "Christine");
            map.put(222534, "Kusuma");
            map.put(223458, "Irawan");
            map.put(224776, "Eka");
            map.forEach((key, value) -> System.out.println(key + "   " + value));
        }
    }
