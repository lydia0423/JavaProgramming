/*Q5:A nonnegative integer is called a palindrome if it reads forward and backward 
in the same way. For example, the numbers 5, 121, 3443, and 123454321 are palindromes. 
Write a method that takes as input a nonnegative integer and returns true if the 
number is a palindrome; otherwise, it returns false. Also write a program to test your method.*/

package method.revision;
import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);    
        int num;

        System.out.print("Enter a number: ");
        num = input.nextInt();
        
        if(IsPalindrome(num))
            System.out.println("Number is palindrome");
        else
            System.out.println("Number is not palindrome");
        
    }
    
    public static boolean IsPalindrome(int num){
        int temp = num;
        int remainder;
        int reverse = 0;
        
        while(temp > 0)
	{
            remainder = temp % 10;
            temp = temp / 10;
            reverse = reverse * 10 + remainder;
	}
        
        return reverse == num;
    }
    
}
