/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabhi.maps.implementHashMap;

/**
 *
 * @author Abhijit Gaikwad <gaikwad.abhijit@gmail.com>
 */
public class HashMapImpl {

    private final static int TABLE_SIZE = 128;
    HashEntry[] table;

    HashMapImpl() {
        table = new HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = null;
        }
    }

    public int get(int key) {
        int hash = (key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key) {
            hash = (hash + 1) % TABLE_SIZE;
        }
        if (table[hash] == null) {
            return -1;
        } else {
            return table[hash].getValue();
        }
    }

    public void put(int key, int value) {
        int hash = (key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key) {
            hash = (hash + 1) % TABLE_SIZE;
        }
        table[hash] = new HashEntry(key, value);
    }
}
