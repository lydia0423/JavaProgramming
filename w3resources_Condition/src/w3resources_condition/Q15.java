/*15. Write a program in Java to display the n terms of odd natural number and their sum.
        Test Data
        Input number of terms is: 5
        Expected Output :

        The odd numbers are :                                                            
        1                                                                                
        3                                                                                
        5                                                                                
        7                                                                                
        9                                                                                
        The Sum of odd Natural Number upto 5 terms is: 25
 */
package w3resources_condition;
import java.util.Scanner;
public class Q15 {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       
       System.out.print("Enter a number of terms: ");
       int num = input.nextInt();
       
       System.out.println("The odd numbers are: ");
       
       int sum = 0;
       
       for(int i = 1; i <= num ; i++){
           System.out.println (2*i-1);
           sum+=2*i-1;
       }
       
       System.out.println("The Sum of odd Natural Number upto 5 terms is: " + sum);
    }
    
}
