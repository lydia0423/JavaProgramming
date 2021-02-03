/*Write a program to enter the numbers till the user wants and at the end the 
program should display the largest and smallest numbers entered.*/
package testrevision;
import java.util.Scanner;

public class LoopsQ12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int max = Integer.MIN_VALUE;  // Intialize max with minimum value
        int min = Integer.MAX_VALUE; 
        char ans;
        
        do{
            System.out.print("Please a number: ");
            int num = input.nextInt();
            
            if(num > max){
               max = num;
            }
        
            if(num < min){
               min = num;
            }
            
            System.out.print("Do you want to continue (Y/N) ?");
            ans = input.next().charAt(0);
            
        }while(ans =='y' || ans == 'Y');
        
        System.out.println("The largest number has been entered: " + max);
        System.out.println("The smallest number has been entered: " + min);
        
    }
    
}
