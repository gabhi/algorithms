/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabhi.maps.implementHashMap;

/**
 *
 * @author Abhijit Gaikwad <gaikwad.abhijit@gmail.com>
 */
public class HashEntry {
      private int key;
      private int value;
 
      HashEntry(int key, int value) {
            this.key = key;
            this.value = value;
      }     
 
      public int getKey() {
            return key;
      }
 
      public int getValue() {
            return value;
      }
}