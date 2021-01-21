/*3. Take three numbers from the user and print the greatest number.
        Test Data
        Input the 1st number: 25
        Input the 2nd number: 78
        Input the 3rd number: 87
        Expected Output :
        The greatest: 87
 */
package w3resources_condition;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the 1st number: ");
        int a = input.nextInt();
        System.out.print("Enter the 1st number: ");
        int b = input.nextInt();
        System.out.print("Enter the 1st number: ");
        int c = input.nextInt();
        
        if(a > b && a > c){
            System.out.print("The greatest number is " + a);
        }else if(b > a && b > c){
            System.out.print("The greatest number is " + b);
        }else{
            System.out.print("The greatest number is " + c);
        }
    }
    
}
