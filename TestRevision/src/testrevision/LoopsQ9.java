/*9.Write a program to calculate HCF (Highest Common Fcator) of Two given number
 */
package testrevision;
import java.util.Scanner;

public class LoopsQ9 {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int remainder, hcf = 0;
        
        System.out.print("Enter the first number ");
        int dividend = input.nextInt();
        
        System.out.print("Enter the second number ");
        int divisor = input.nextInt();        
        
        do
	{
            remainder = dividend % divisor;
            
            if(remainder == 0)
            {
                hcf = divisor;
            }
	    else
            {
                dividend = divisor;
                divisor = remainder;
	    }
            
        }while(remainder != 0);
            System.out.println("HCF: " + hcf);
    }
    
}
