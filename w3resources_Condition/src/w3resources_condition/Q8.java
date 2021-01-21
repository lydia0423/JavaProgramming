/*8. Write a Java program that takes the user to provide a single character from 
the alphabet. Print Vowel or Consonant, depending on the user input. If the user 
input is not a letter (between a and z or A and Z), or is a string of length > 1, 
print an error message. 

        Test Data
        Input an alphabet: p
        Expected Output :
        Input letter is Consonant
 */
package w3resources_condition;
import java.util.Scanner;

public class Q8 {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       
       System.out.print("Enter a character: ");
       String ch = input.next();
       
       if(ch.equals("a") || ch.equals("e") || ch.equals("i") || ch.equals("o") || ch.equals("u")){
           System.out.println(ch + " is vowel");
       }else if(ch.length() > 1){
           System.out.println("Error");
       }else{
           System.out.println(ch + " is consonant");
       }
       
    }
    
}
