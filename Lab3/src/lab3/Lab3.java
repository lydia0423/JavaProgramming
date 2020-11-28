package lab3;
import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int i;
        int number = 0;
        int largest = 0;
        
        for(i = 0; i < 5; i++)
        {
            System.out.print("Enter a number: ");
            number = input.nextInt();
            
            if(i == 0){
                largest = number;
            }else{
                if(number > largest)
                    largest = number;
            }
                       
        }
        
        System.out.println("The largest number is: " + largest);
        
    }
}
