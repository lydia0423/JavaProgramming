/*2. Write a Java program to sum values of an array.*/

package w3resources_array;

public class Q2 {
    public static void main(String[] args) {
        int myArray[] = {1, 2 ,3, 4, 5, 6, 7, 8, 9};
        
        int sum = 0;
        
        //For each integer i in the array called myArray
        for(int i : myArray){
            sum += i;
        }
        
        System.out.println("The sum of the array: " + sum);
    }
    
}
