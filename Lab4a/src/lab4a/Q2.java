package lab4a;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int i;
        int[] num = new int[10];
        int odd_count = 0;
        int even_count = 0;
        
        for(i=0; i<10; i++){
            System.out.print("Enter a number: ");
            num[i] = input.nextInt();
            
            if(i % 2 == 0)
                even_count++;
            else
                odd_count++;
        }
        
        System.out.println("The total number of even numbers entered are: " + even_count);
        System.out.println("The total number of odd numbers entered are: " + odd_count);    
    }   
}
