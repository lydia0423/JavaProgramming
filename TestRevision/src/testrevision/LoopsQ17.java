/*Write a program that generates a random number and asks the user to guess what
the number is. If the user's guess is higher than the random number, the program
should display "Too high, try again." If the user's guess is lower than the random
number, the program should display "Too low, try again." The program should use a 
loop that repeats until the user correctly guesses the random number.*/
package testrevision;
import java.util.Scanner;

public class LoopsQ17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double random = Math.random();
        double ans;
        
        do{
            System.out.print("Please guess a random number: ");
            ans = input.nextDouble();
            
            if(ans > random){
                System.out.println("Too high, try again");
            }
            
            if(ans < random){
               System.out.println("Too low, try again"); 
            }
            
            if(ans == random){
                System.out.println("Tou are right"); 
            }
        }while(ans > random || ans < random);
    }
    
}
