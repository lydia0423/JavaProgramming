/*5.Two numbers are entered through the keyboard. Write a program to find the value 
of one number raised to the power of another. (Do not use Java built-in method)*/
package testrevision;
import java.util.Scanner;

public class LoopsQ5 {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        System.out.print("Please enter the base: ");
        int a = input.nextInt();
        System.out.print("Please enter the power: ");
        int b = input.nextInt();
        
        int sum = 1;
        for(int i = 1; i <= b; i++){
            sum *= a;
        }
        
        System.out.println("Result: " + sum);
        
    }
    
}
