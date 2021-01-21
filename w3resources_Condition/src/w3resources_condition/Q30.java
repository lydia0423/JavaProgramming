/*30. Write a Java program that accepts three numbers and prints 
"All numbers are equal" if all three numbers are equal, "All numbers are different" 
if all three numbers are different and "Neither all are equal or different" otherwise. 

    Test Data
    Input first number: 2564
    Input second number: 3526
    Input third number: 2456
    Expected Output :

    All numbers are different
 */
package w3resources_condition;
import java.util.Scanner;

public class Q30 {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       
       System.out.println("Enter 3 numbers: ");
       int a = input.nextInt();
       int b = input.nextInt();
       int c = input.nextInt();
       
       if(a == b && a == c && b == c){
           System.out.println("All numbers are equal");
       }else if(a != b && a != c && b != c){
           System.out.println("All numbers are different");
       }else{
           System.out.println("Neither all are equal or different");
       }
    }
    
}
