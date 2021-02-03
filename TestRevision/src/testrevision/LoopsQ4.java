/*4.Write a program to find the factorial value of any number entered through the keyboard. */
package testrevision;
import java.util.Scanner;

public class LoopsQ4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please eneter an positive integer: ");
        int num = input.nextInt();
        
        int factorial = 1;
        
        for(int i = 1; i <= num; i++){
            factorial *= i;
        }
        
        System.out.println("Fatorial of a number: " + factorial);
        
    }
    
}
