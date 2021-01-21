/*11. Write a program in Java to display n terms of natural numbers and their sum.

        Test Data
        Input the number: 2
        Expected Output :

        Input number:                                                                    
        2                                                                                
        The first n natural numbers are :                                                
        2                                                                                
        1                                                                                
        2                                                                                
        The Sum of Natural Number upto n terms :                                         
        23
 */
package w3resources_condition;
import java.util.Scanner;

public class Q11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        
        int sum = 0;
        int i;
        
        System.out.println("Input number: " + n);
        System.out.println("The first n natural numbers are: ");
        System.out.print(n + "\n");
        
        for(i = 1; i <= n; i++){
            System.out.print(i + "\n");
            sum += i;  
        }
        
        
        //System.out.print(i + "\n");
        System.out.println("The Sum of Natural Number upto n terms:");
        System.out.print(n);
        System.out.print(sum);
    }
    
}
