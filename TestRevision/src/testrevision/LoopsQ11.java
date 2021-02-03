/*11.Write a program to enter the numbers till the user wants and at the end it 
should display the count of positive, negative and zeros entered.*/
package testrevision;
import java.util.Scanner;

public class LoopsQ11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int positive = 0;
        int negative = 0;
        int zero = 0;
        char ans;
        
        do{
            System.out.print("Please a number: ");
            int num = input.nextInt();
            
            if(num > 0){
                positive ++;
            }else if(num < 0){
                negative ++;
            }else{
                zero++;
            }
            
            System.out.print("Do you want to continue (Y/N) ?");
            ans = input.next().charAt(0);
            
        }while(ans =='y' || ans == 'Y');
        
                    
        System.out.println("Number of positive numbers haveb been entered: " + positive);
        System.out.println("Number of negative numbers haveb been entered: " + negative);
        System.out.println("Number of zero numbers haveb been entered: " + zero);
    }
    
}
