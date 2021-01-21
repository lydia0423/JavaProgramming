/*17. Write a program in Java to make such a pattern like right angle triangle with a 
number which will repeat a number in a row.The pattern is as follows : 

        1
        22
        333
        4444
 */
package w3resources_condition;
import java.util.Scanner;

public class Q17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number of rows: ");
        int row = input.nextInt();
        
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(i);   
            }
            System.out.println("");
        }
    }
        
    
}
