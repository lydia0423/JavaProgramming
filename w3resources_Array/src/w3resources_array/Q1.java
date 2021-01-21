/*1. Write a Java program to sort a numeric array and a string array.*/

package w3resources_array;

import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) {
        
        int[] myArray1 = {9, 3, 5, 1, 2, 6, 4, 7, 8};
        String[] myArray2 = {"Java", "Python", "Flutter", "HTML", "C++"};
        
        System.out.println("Original numeric array: " + Arrays.toString(myArray1));
        Arrays.sort(myArray1);
        System.out.println("Sorted numeric array: " + Arrays.toString(myArray1));
        
        System.out.println("Original string array: " + Arrays.toString(myArray2));
        Arrays.sort(myArray2);
        System.out.println("Sorted string array: " + Arrays.toString(myArray2));
        
    }
    
}
