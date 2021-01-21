/*6. Write a Java program that reads in two floating-point numbers and tests 
whether they are the same up to three decimal places. 

    Test Data
    Input floating-point number: 25.586
    Input floating-point another number: 25.589
    Expected Output :
    They are different
 */
package w3resources_condition;
import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the 1st floating-point number: ");
        double a = input.nextDouble();
        System.out.print("Enter the 2nd floating-point number: ");
        double b = input.nextDouble();
        
        if(a == b){
            System.out.println("There are same");
        }else{
             System.out.println("There are different");
        }
        
    }
    
}
