package lecturec3;
import java.util.Scanner;

public class LectureC3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int a;
        int b;
        int c;
        
        System.out.print("Please enter the first interger: ");
        a = input.nextInt();
        System.out.print("Please enter the second interger: ");
        b = input.nextInt();
        System.out.print("Please enter the third interger: ");
        c = input.nextInt();
        
        if(a< b && a<c){
            System.out.println("The smallest integer is " + a);
        }else if (b<a && b<c){
            System.out.println("The smallest integer is " + b);
        }else
            System.out.println("The smallest integer is " + c);
        
        
    }
    
}
