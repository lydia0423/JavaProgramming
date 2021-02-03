/*15.Write a program to calculate the sum of following series where n is input by user. 
1 + 1/2 + 1/3 + 1/4 + 1/5 +…………1/n */
package testrevision;
import java.util.Scanner;

public class LoopsQ15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter a number: ");
        int num = input.nextInt();
        
        double sum = 0;
        
        for(int i = 1; i <= num; i++){
            sum += 1.0/i;
        }
        
        System.out.print("Sum: " + sum);
    }
    
}
