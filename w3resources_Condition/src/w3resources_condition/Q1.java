/*1. Write a Java program to get a number from the user and print whether it is positive or negative.
        Input number: 35
        Expected Output :
        Number is positive
*/

package w3resources_condition;
import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int number = input.nextInt();
        
        if(number > 0){
            System.out.print(number + " is positive");
        }else if(number < 0){
            System.out.print(number + " is negative");
        }else if(number == 0){
           System.out.print(number + " is not catagorize as positive or negative");
        }
    }
    
}
