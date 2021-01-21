/*5. Write a Java program that keeps a number from the user and generates an 
integer between 1 and 7 and displays the name of the weekday.

Test Data
Input number: 3
Expected Output :
Wednesday
 */
package w3resources_condition;
import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number between 1 to 7: ");
        int day = input.nextInt();
        
        switch(day){
            case 1:
                System.out.print("Monday");break;
            case 2:
                System.out.print("Tuesday");break;
            case 3:
                System.out.print("Wednesday");break;
            case 4:
                System.out.print("Thursday");break;
            case 5:  
                System.out.print("Friday");break;
            case 6:  
                System.out.print("Saturday");break;
            case 7:
                System.out.print("Sunday");break;
        }
    }
    
}
