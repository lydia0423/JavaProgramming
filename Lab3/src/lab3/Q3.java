package lab3;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int num;
        int product = 1;
        
        do{
            System.out.print("Enter a number: ");
            num = input.nextInt();
            
            if(num > 0){  
                product *= num;
            }
        } while (num >= 0);

        
        
        System.out.println("\n Product = " + product);
    }
    
}
