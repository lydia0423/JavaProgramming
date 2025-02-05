/*34. Write a Java program to find the length of the longest consecutive elements sequence from a given unsorted array of integers.
Sample array: [49, 1, 3, 200, 2, 4, 70, 5]
The longest consecutive elements sequence is [1, 2, 3, 4, 5], therefore the program will return its length 5.
*/
package w3resources_array;

import java.util.HashSet;

public class Q34 {
    public static void main(String[] args) {
        int nums[] = {49, 1, 3, 200, 2, 4, 70, 5};  
	System.out.println("Original array length: "+nums.length);
        System.out.print("Array elements are: ");
        
        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i]+" ");
        }
	System.out.println("\nThe new length of the array is: "+longest_sequence(nums));
    }

    private static int longest_sequence(int[] nums) {
        final HashSet<Integer> h_set = new HashSet<Integer>();
        for (int i : nums){
            h_set.add(i);
        }

        int longest_sequence_len = 0;
        
        for (int i : nums) {
            int length = 1;
            for (int j = i - 1; h_set.contains(j); --j) {
                h_set.remove(j);
                ++length;
            }
            for (int j = i + 1; h_set.contains(j); ++j) {
                h_set.remove(j);
                ++length;
            }
            longest_sequence_len = Math.max(longest_sequence_len, length);
        }
        return longest_sequence_len;
    }
    
}
