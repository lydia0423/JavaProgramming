package lab4a;
import java.util.Scanner;

public class Lab4a {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int i;
        int[] number= new int[5];
        int sum = 1;
        
        for(i=0; i<5; i++){
            System.out.print("Enter a number: ");
            number[i] = input.nextInt();
            sum = sum * number[i];
        }
        
        System.out.println("Total: " + sum);
    }
    
}
