package lab3;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
                
        int intX;
        int small =0, medium=0, large=0, total=0;
        
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter x: ");
            intX = input.nextInt();
            
            if(intX > 100){
                large++;
            } else if (intX < 0){
                small++;
            } else {
                medium++;
            }
            total+= intX;
        }
    
        System.out.println("Total = " + total);
        System.out.println("Large = " + large);
        System.out.println("Medium = " + medium);
        System.out.println("Small = " + small);
    
    }
    
}
