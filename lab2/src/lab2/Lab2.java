package lab2;
import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int num;
        
        System.out.print("Enter a num: ");
        num = input.nextInt();
        
        if(num % 2 == 0)
            System.out.println(num + " is even number");
        else
            System.out.println(num + " is odd number");

    }
    
}
