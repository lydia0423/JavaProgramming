/*3.Write a program that will read a series of integers from the user and store 
them in an array called num[]. The program should then determine and display the 
lowest of all integers entered by the user.

	Sample input-output :
	Enter total numbers to read : 5
	Key in 5 numbers : 
	3 6 8  4 7
	The lowest of all the values is : 3
 */
package testrevision;
import java.util.Scanner;

public class Q3AddArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int num[] = new int[5];
        int i;
        
        for(i = 0; i < num.length; i++){
            System.out.print("Enter 5 numbers: ");
            num[i] = input.nextInt();   
        }
        
        if(num[0] < num[1] && num[0] < num[2] && num[0] < num[3] && num[0] < num[4] ) {
            System.out.println("The lowest of all the values is: " + num[0] );
        } else if(num[1] < num[0] && num[1] < num[2] && num[1] < num[3] && num[0] < num[4]) {
            System.out.println("The lowest of all the values is: " + num[1] );
        } else if(num[2] < num[0] && num[2] < num[1] && num[2] < num[3] && num[2] < num[4]) {
            System.out.println("The lowest of all the values is: " + num[2] );
        } else if(num[3] < num[0] && num[3] < num[1] && num[3] < num[2] && num[3] < num[4]) {
            System.out.println("The lowest of all the values is: " + num[3] );
        } else if(num[4] < num[0] && num[4] < num[1] && num[4] < num[2] && num[4] < num[3]) {
            System.out.println("The lowest of all the values is: " + num[4] );
        }
 
    }

}
    
