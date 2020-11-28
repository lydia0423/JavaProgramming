package lab1;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double A;
        double r;
        double L;
        double V;
        
        System.out.print("Please enter your radius: ");
        r = input.nextDouble();
        A = r * r * 3.1419;
        
        System.out.print("Please enter your length: ");
        L = input.nextDouble();
        V = A * L;
        
        System.out.println("Area of cylinder is " + A);
        System.out.println("Volume of cylinder is " + V);
        
        
        
    }
    
}
