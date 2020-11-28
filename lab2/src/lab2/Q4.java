package lab2;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int marks;
        
        System.out.print("Enter your marks: ");
        marks= input.nextInt();
        
        if(marks >= 80 && marks <= 100){
            System.out.println("The grade is A+ and it is distinction");
        }else if(marks >= 75 && marks <= 79){
            System.out.println("The grade is A and it is distinction");
        }else if(marks >= 70 && marks <= 74){
            System.out.println("The grade is B+ and it is credit");
        }else if(marks >= 65 && marks <= 69){
            System.out.println("The grade is B and it is credit");
        }else if(marks >= 55 && marks <= 64){
            System.out.println("The grade is C and it is pass");
        }else if(marks >= 50 && marks <= 54){
            System.out.println("The grade is D and it is pass");
        }else if(marks >= 40 && marks <= 49){
            System.out.println("The grade is F+ and it is marginal fail");
        }else if(marks >= 0 && marks <= 40){
            System.out.println("The grade is F and it is fail");
        }else
            System.out.println("The input is invalid");
    }
    
}
