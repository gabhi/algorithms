/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gabhi.com.search;

/**
 *
 * @author Abhijit Gaikwad <gaikwad.abhijit@gmail.com>
 */
//Implement Binary Search

/**
 *A straightforward implementation of binary search is recursive. 
 * The initial call uses the indices of the entire array to be searched. 
 * The procedure then calculates an index midway between the two indices, 
 * determines which of the two subarrays to search, and then does a recursive call to search that subarray. 
 * Each of the calls is tail recursive, so a compiler need not make a new stack frame for each call. 
 * The variables imin and imax are the lowest and highest inclusive indices that are searched.
 
 */
public class BinarySearch {

    public static final int NOT_FOUND = -1;

    public static void main(String[] args) {
        int SIZE = 8;
        Comparable[] a = new Integer[SIZE];
        for (int i = 0; i < SIZE; i++) {
            a[ i] = new Integer(i * 2);
        }

        for (int i = 0; i < SIZE * 2; i++) {
            System.out.println("Found " + i + " at "
                    + binarySearch(a, new Integer(i)));
        }

    }

    public static int binarySearch(Comparable[] a, Comparable x) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (a[ mid].compareTo(x) < 0) {
                low = mid + 1;
            } else if (a[ mid].compareTo(x) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return NOT_FOUND;     // NOT_FOUND = -1
    }
}
