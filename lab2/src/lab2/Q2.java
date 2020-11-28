package lab2;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       
       float a, b, c;
       
       System.out.print("Enter the first edge: ");
       a = input.nextFloat();
       System.out.print("Enter the second edge: ");
       b = input.nextFloat();
       System.out.print("Enter the third edge: ");
       c = input.nextFloat();
       
       if(a + b > c)
           System.out.println("The perimeter of triangle is " + (a + b + c) );
       else if (a+ c > b)
           System.out.println("The perimeter of triangle is " + (a + b + c) );
       else if(c + b > a)
           System.out.println("The perimeter of triangle is " + (a + b + c) );
       else
           System.out.println("The input is invalid");
    }
    
}
