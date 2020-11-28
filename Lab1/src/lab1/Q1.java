package lab1;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double F;
        double C;
        
        System.out.print("Input in Fahrenheit: ");
        F = input.nextDouble();
        C = (F - 32) * 5 /9;
        
        System.out.println(F + " Fahrenheit = " + C + " Celcius");
    }
    
}
