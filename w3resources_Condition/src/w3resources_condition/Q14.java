/*14. Write a program in Java to display the multiplication table of a given integer.

        Test Data
        Input the number (Table to be calculated) : Input number of terms : 5
        Expected Output :

        5 X 0 = 0                                                                        
        5 X 1 = 5                                                                        
        5 X 2 = 10                                                                       
        5 X 3 = 15                                                                       
        5 X 4 = 20                                                                       
        5 X 5 = 25
 */
package w3resources_condition;
import java.util.Scanner;

public class Q14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number of terms: ");
        int num = input.nextInt();
        
        for(int i=0; i <= num; i++){
            int sum = num * i;
            System.out.println(num + " x " + i + " = " + sum );
        }
    }
    
}
