package com.study.dsa.week1;

import java.util.HashMap;
import java.util.Map;

/*
        1.In the above code, we have implemented a simple HashMap simulation.
          The `put` method checks if the size of the map has exceeded the load factor threshold before adding a new key-value pair.
          If it has, it resizes the internal array to accommodate more entries.
        2. if Point class act as key then must override a equals() and hashCode
              method otherwise it will not work as expected because HashMap uses these methods to determine the uniqueness of keys and to manage collisions.
              it will treat different instances of Point with the same coordinates as different keys, leading to unexpected behavior when retrieving values from the map (most return null).
 */
public class HashMapSimulation {
    private Object[] table;
    private int size = 0;
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    public HashMapSimulation() {
        table = new Object[INITIAL_CAPACITY];
    }

    public void put(String key, String value){
        if(isSizeExceeded()){
            resize();
        }
        int index = key.hashCode() & (table.length - 1);
        table[index] = value;
        size++;
    }

    private void resize() {
        Object[] newTable = new Object[table.length * 2];
        Object[] oldTable = table;
        table = new Object[newTable.length];
        size = 0;
        System.out.println("Resizing table to new capacity: " + newTable.length);
    }

    private boolean isSizeExceeded() {
        return size >= table.length * LOAD_FACTOR;
    }

    public static void main(String[] args) {
        HashMapSimulation map = new HashMapSimulation();
        
        for (int i = 1; i <= 13; i++) {
            map.put("key" + i, "value" + i);
        }



        Map<Point, String> pointMap = new HashMap<>();
        pointMap.put(new Point(1, 2), "Point A");
        pointMap.put(new Point(1, 2), "Point B");

        System.out.println(pointMap.get(new Point(1, 2)));

    }
}