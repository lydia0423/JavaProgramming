/*31. Write a program that accepts three numbers from the user and prints 
"increasing" if the numbers are in increasing order, "decreasing" if the numbers
are in decreasing order, and "Neither increasing or decreasing order" otherwise.

        Test Data
        Input first number: 1524
        Input second number: 2345
        Input third number: 3321
        Expected Output :

        Increasing order
 */
package w3resources_condition;
import java.util.Scanner;

public class Q31 {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       
       System.out.print("Enter first number: ");
       int a = input.nextInt();
       System.out.print("Enter second number: ");
       int b = input.nextInt();
       System.out.print("Enter third number: ");
       int c = input.nextInt();
       
       if(c > b && b > a && c > a){
           System.out.println("Increasing order");
       }else if(a > b && a > c && b > c){
           System.out.println("Decreasing order");
       }else{
           System.out.println("Neither increasing or decreasing order");
       }
    }
    
}
