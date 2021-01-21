/*29. Write a Java program that reads an positive integer and count the number 
of digits the number (less than ten billion) has. 

        Test Data
        Input an integer number less than ten billion: 125463
        Expected Output :

        Number of digits in the number: 6
 */
package w3resources_condition;
import java.util.Scanner;

public class Q29 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer number less than ten billion: ");
        int num = input.nextInt();
        
        int count = 0;

        while (num != 0) {
          num /= 10;
          ++count;
        }
        
        if(num < 1000000000){
            System.out.println("Number of digits in the number: " + count );
        }else{
            System.out.print("Error");
        }
    }
    
}
