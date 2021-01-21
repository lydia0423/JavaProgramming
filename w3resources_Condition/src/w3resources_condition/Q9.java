/*9. Write a Java program that takes a year from user and print whether that year 
is a leap year or not. 

    Test Data
    Input the year: 2016
    Expected Output :
    2016 is a leap year
 */
package w3resources_condition;
import java.util.Scanner;

public class Q9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a year: ");
        int year = input.nextInt();
        
        if(year % 4 == 0 || year % 100 == 0 && year % 400 == 0){
            System.out.println(year + " is a leap year");
        }else{
            System.out.println(year + " is not a leap year");
        }
    }
    
}
