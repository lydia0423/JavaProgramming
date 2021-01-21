/*21. Write a program in Java to display the pattern like a diamond. Go to the editor

        Test Data
        Input number of rows (half of the diamond) : 7
        Expected Output :


              *                                                                          
             ***                                                                         
            *****                                                                        
           *******                                                                       
          *********                                                                      
         ***********                                                                     
        *************                                                                    
         ***********                                                                     
          *********                                                                      
           *******                                                                       
            *****                                                                        
             ***                                                                         
              *     
 */
package w3resources_condition;
import java.util.Scanner;

public class Q21 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number of rows (half of the diamond): ");
        int row = input.nextInt();
        
        for(int i=0;i <= row;i++){
            for(int j=1; j <= row - i;j++){
               System.out.print(" "); 
            }
            for(int j=1; j <= 2 * i - 1 ; j++){
               System.out.print("*");  
            } 
            System.out.print("\n");
        }
 
        for(int i = row - 1; i >= 1; i--){
          for(int j = 1; j <= row - i; j++){
            System.out.print(" ");  
          }
          for(int j=1;j <= 2 * i - 1 ;j++){
            System.out.print("*");  
          }  
          System.out.print("\n");
        }
    }
    
}
