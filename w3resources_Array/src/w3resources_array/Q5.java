/*5. Write a Java program to test if an array contains a specific value.*/

package w3resources_array;

public class Q5 {
    public static void main(String[] args) {
        int[] myArray = {101, 201, 111, 301, 401, 501};
        
        System.out.print(contains(myArray, 111));
        System.out.print(contains(myArray, 598));
    }

    private static boolean contains(int[] myArray, int i) {
        for (int n : myArray){
            if (i == n){
               return true;
            }
        }
        return false;
   }
}
    

