/*20. Write a program in Java to print the Floyd's Triangle.
    Test Data
    Input number of rows : 5
    Expected Output :

    Input number of rows :  5
    1 
    2 3 
    4 5 6 
    7 8 9 10 
    11 12 13 14 15 
 */
package w3resources_condition;
import java.util.Scanner;

public class Q20 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number of rows: ");
        int row = input.nextInt();
        int k = 1;
        
        for(int i = 1; i <= row ; i++){
            for(int j = 1; j <= i; j ++){
                System.out.print(k++);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    
}
