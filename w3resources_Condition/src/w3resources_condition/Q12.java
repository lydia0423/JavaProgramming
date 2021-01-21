/*12. Write a program in Java to input 5 numbers from keyboard and find their sum and average.

        Test Data
        Input the 5 numbers : 1 2 3 4 5
        Expected Output :

        Input the 5 numbers :                                                            
        1                                                                                
        2                                                                                
        3                                                                                
        4                                                                                
        5                                                                                
        The sum of 5 no is : 15                                                          
        The Average is : 3.0  
 */
package w3resources_condition;
import java.util.Scanner;

public class Q12 {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       
       System.out.println("Enter the 5 numbers: ");
       int a = input.nextInt();
       int b = input.nextInt();
       int c = input.nextInt();
       int d = input.nextInt();
       int e = input.nextInt();
       
       int sum = (a + b + c + d + e);
       double avg = (sum/5);
       
       System.out.println("The sum of 5 no is: " + sum);
       System.out.println("The Average is: " + avg);
       
       
    }
    
}
