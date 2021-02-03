/*3.Write a program that prompts the user to input a positive integer. It should then print the multiplication table of that number. */
package testrevision;
import java.util.Scanner;

public class LoopsQ3 {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       System.out.print("Please enter and positive integer: ");
       int num = input.nextInt();
       
       int product = 0;
       for(int i = 0; i <=12; i++){
           product = i * num;
           System.out.println(num + " x " + i + " = " + product);
       }
       
    }
    
}
