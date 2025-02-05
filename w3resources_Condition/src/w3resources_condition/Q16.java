/*16. Write a program in Java to display the pattern like right angle triangle with a number. 

        Test Data
        Input number of rows : 10
        Expected Output :

        1                                                                                
        12                                                                               
        123                                                                              
        1234                                                                             
        12345                                                                            
        123456                                                                           
        1234567                                                                          
        12345678                                                                         
        123456789                                                                        
        12345678910
 */
package w3resources_condition;
import java.util.Scanner;

public class Q16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number of rows: ");
        int row = input.nextInt();
        
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= i; j++){
               System.out.print(j);
               System.out.println(""); 
            }    
        }
    }
    
}
