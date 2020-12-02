/*Q2:Write a method named isEven that accepts an int argument. The method should 
return true if the argument is even, or false otherwise. Also write a program 
to test your method.*/

package method.revision;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       
        int num;
       
        System.out.print("Enter a number: ");
        num = input.nextInt();
       
        if(IsEven(num))
            System.out.println( num + " is an even number.");
        else
            System.out.println(num + " is not an even number.");
    }
    
    public static boolean IsEven(int num){
        if(num % 2 == 0)
            return true;
        else
            return false;
    }
}
