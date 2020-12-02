/*Q1: Write a program with a method named getTotal that accepts two integers as an 
 argument and return its sum. Call this method from main( ) and print the results.*/

package method.revision;
import java.util.Scanner;

public class MethodRevision {
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         
         int a,b;
         
         System.out.print("Enter first number: ");
         a = input.nextInt();
         
         System.out.print("Enter second number: ");
         b = input.nextInt();
         
         int sum = getTotal(a, b);
         System.out.println("Sum:" + sum);

    }
    
    public static int getTotal(int a, int b){
        return a + b;
    }
    
    
}
