package mocktest;
import static java.lang.System.in;
import java.util.Arrays;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int amtOfNums = 0;
        int in = 0;
        System.out.println("Enter a series of numbers. Enter a negative number to quit.");
        int next = input.nextInt();

        while ((in = input.nextInt()) > 0) {
            amtOfNums++;
        }
        //System.out.println("Numbers entered " + );
    }
        
}
    
