/*6. Write a Java program to find the index of an array element.*/
package w3resources_array;

public class Q6 {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        System.out.println("The index position of 2: " + findIndex(myArray, 2));
        System.out.println("The index position of 7: " + findIndex(myArray, 7));
        
    }

    private static int findIndex(int[] myArray, int t) {
        if (myArray == null){
            return -1;
        }
        
        int len = myArray.length;
        int i = 0;
        
        while (i < len) {
            if (myArray[i] == t) {
                return i;
            }else i=i+1;
        }
        return -1;
    }
    
}
