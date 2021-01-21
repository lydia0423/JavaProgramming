/*13. Write a program in Java to display the cube of the number upto given an integer.

        Test Data
        Input number of terms : 4
        Expected Output :

        Number is : 1 and cube of 1 is : 1                                               
        Number is : 2 and cube of 2 is : 8                                               
        Number is : 3 and cube of 3 is : 27                                              
        Number is : 4 and cube of 4 is : 64
 */
package w3resources_condition;
import java.util.Scanner;

public class Q13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a number of terms: ");
        int num = input.nextInt();
        
        for(int i= 1; i <= num; i++){
            int cube = (int) Math.pow(i, 3);
            System.out.println("Number is: " + i + " and cube of " + i + " is: " + cube );
        }
    }
    
}
