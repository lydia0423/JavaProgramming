/*4. Write a Java program that reads a floating-point number and prints "zero" if the number is zero.
Otherwise, print "positive" or "negative". Add "small" if the absolute value of the number 
is less than 1, or "large" if it exceeds 1,000,000.

    Test Data
    Input a number: 25
    Expected Output :
    Input value: 25
    Positive number
 */
package w3resources_condition;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        double number = input.nextDouble();
            
        if(number > 0){
            if(number < 1){
                System.out.println("Input value: " + number);
                System.out.println("Positive small number");
            }else if(number > 1000000){
                System.out.println("Input value: " + number);
                System.out.println("positive large number");
            }else{
                System.out.println("Input value: " + number);
                System.out.println("Positive number"); 
            }
        }else if(number < 0){
            if(Math.abs(number) < 1){
                System.out.println("Input value: " + number);
                System.out.println("Negative small number");
            }else if(Math.abs(number) > 1000000){
                System.out.println("Input value: " + number);
                System.out.println("Negative large number");
            }else{
                System.out.println("Input value: " + number);
                System.out.println("Negative number"); 
            }
            
        }else{
            System.out.println("Input value: " + number);
            System.out.println("Zero");
        }
            
        
    }
    
}
