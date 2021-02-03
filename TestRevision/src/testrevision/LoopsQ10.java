/*10.Write a do-while loop that asks the user to enter two numbers. 
The numbers should be added and the sum displayed. The loop should 
ask the user whether he or she wishes to perform the operation again. If so, 
the loop should repeat; otherwise it should terminate. 
 */
package testrevision;
import java.util.Scanner;

public class LoopsQ10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char ans;
        
        do{
           System.out.println("Please enter 2 numbers: ");
            int a = input.nextInt();
            int b = input.nextInt(); 
            
            System.out.print("Sum: " + (a +b));
            
            System.out.print("Do you want to continue (Y/N) ?");
            ans = input.next().charAt(0);
            
            System.out.println();
            
        }while(ans =='y' || ans == 'Y');
    }
    
}
