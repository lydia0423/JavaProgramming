/*19. Write a program in Java to make such a pattern like a pyramid with a 
number which will repeat the number in the same row.

       1
      2 2
     3 3 3
    4 4 4 4 
 */
package w3resources_condition;
import java.util.Scanner;

public class Q19 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number of row: ");
        int row = input.nextInt();
        
        int s= row+4-1;
        int x;
        
        for(int i = 1; i <= row; i++){
            for(x = s; x != 0; x--){
                System.out.print(" ");
            }
            for(int j = 0; j < i; j++){
                System.out.print(i + " ");
                System.out.print("");
            }
            System.out.println("");
            s--;
        }
    }
    
}
