/*4. Write a Java program to calculate the average value of array elements.*/

package w3resources_array;

public class Q4 {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = 0, n;
        
        for(int i : myArray){
            sum += i;
        }
        
        n = myArray.length;

        double avg = sum / n;
        System.out.println("The average of the array is: " + avg);
    }
    
}
