/*1.Write a program that will read a series of number from the user and store 
them in an array called number[]. The program should calculate and display the 
product of all integers entered by the user.

    Sample input-output :
    Enter total numbers to read : 5
    Key in 5 numbers : 
    3 6 5 4 7

    The product is : 2520

 */
package testrevision;
import java.util.Scanner;

public class Q1AddArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int number[] = new int[5];
        int i;
        int sum = 1;
        
        for(i = 0; i < number.length; i++){
            System.out.print("Enter 5 numbers: ");
            number[i] = input.nextInt();
            sum *= number[i];
        }
        
        System.out.println("The product is: " + sum);
    }
    
}
