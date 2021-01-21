/*18. Write a program in Java to make such a pattern like right angle triangle 
with number increased by 1.The pattern like : 

        1
        2 3
        4 5 6
        7 8 9 10 
 */
package w3resources_condition;
import java.util.Scanner;

public class Q18 {
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
