/*33. Write a Java program to remove the duplicate elements of a given array and return the new length of the array.
Sample array: [20, 20, 30, 40, 50, 50, 50]
After removing the duplicate elements the program should return 4 as the new length of the array.*/
package w3resources_array;

public class Q33 {
    public static void main(String[] args) {
        int nums[] = {20, 20, 30, 40, 50, 50, 50};  
        System.out.println("Original array length: "+ nums.length);
	System.out.print("Array elements are: ");
              
       for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println("\nThe new length of the array is: "+array_sort(nums));
    }

    private static int array_sort(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index-1])
                nums[index++] = nums[i];
        }
	return index;
    }
    
}
