
package mocktest;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Menu");
        System.out.println("--------------------------");
        System.out.println("1 C");
        System.out.println("2 Java");
        System.out.println("3 VB.Net");
        
        System.out.println("Please enter your choice: ");
        int ans = input.nextInt();
       
        
        switch(ans){
            case 1:
                System.out.println("My favourite programming language is: C");break;
            case 2: 
                System.out.println("My favourite programming language is: Java");break;
            case 3:
                System.out.println("My favourite programming language is: VB.Net");break;
            case 4:
                System.out.println("I do not have any favourite programming language.");break;
                
        }
    }
    
}
