/*7. Write a Java program to remove a specific element from an array.*/
package w3resources_array;
import java.util.Arrays;

public class Q7 {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        System.out.println("Original array: " + Arrays.toString(myArray));
        
        // Remove the second element (index->1, value->2) of the array
        int removeIndex = 1;
        
        for(int i = removeIndex; i < myArray.length -1; i++){
            myArray[i] = myArray[i + 1];
        }
        
        // We cannot alter the size of an array , after the removal, the last and second last element in the array will exist twice
        System.out.println("After removing the second element: "+Arrays.toString(myArray));
    }
    
}
