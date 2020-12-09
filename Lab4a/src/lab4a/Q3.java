package lab4a;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int i;
        int[] num = new int[5];
        
        for(i=0; i<5; i++){
            System.out.print("Enter a number: ");
            num[i] = input.nextInt();               
        }
        
        if(num[0] < num[1] && num[0] < num[2] && num[0] < num[3] && num[0] < num[4] )
            System.out.println("The lowest of all the values is: " + num[0] ); 
        else if(num[1] < num[0] && num[1] < num[2] && num[1] < num[3] && num[0] < num[4])
            System.out.println("The lowest of all the values is: " + num[1] );
        else if(num[2] < num[0] && num[2] < num[1] && num[2] < num[3] && num[2] < num[4])
            System.out.println("The lowest of all the values is: " + num[2] );
        else if(num[3] < num[0] && num[3] < num[1] && num[3] < num[2] && num[3] < num[4])
            System.out.println("The lowest of all the values is: " + num[3] );
        else if(num[4] < num[0] && num[4] < num[1] && num[4] < num[2] && num[4] < num[3])
            System.out.println("The lowest of all the values is: " + num[4] );
        else
            System.out.println("The lowest of all the values is: " + num[5] );
 
    }
    
}
