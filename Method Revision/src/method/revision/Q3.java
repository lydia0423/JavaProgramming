/*Write a value-returning method, isVowel that returns the value true if a given 
character is a vowel, and otherwise returns false. In main() method accept a 
string from user and count number of vowels in that string.*/

package method.revision;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word;
        
        System.out.print("Enter a word: ");
        word = input.next();
        
        int count =0;
        for(int i = 0; i< word.length(); i++)
        {
            if(IsVowel(word.charAt(i)))
            {
                count ++;
            }
            
        }
        
        System.out.println("Number of vowels: " + count);
        
        
    }
    
    public static boolean IsVowel(char letter){
        switch(letter)
        {
            case 'a':
            case 'A':
            case 'e':
            case 'E':
            case 'i':
            case 'I':
            case 'o':
            case 'O':
            case 'u':
            case 'U':
                return true;
              
            default:
                return false;
                
        }
    }
    
}
