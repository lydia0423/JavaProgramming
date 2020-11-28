package lab1;
import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        String name;
        int age;
        double height;
        char grade;
        
        //create object for class scanner--allow to read inputs from keyboard
        //className objectName = new constructor();
        //contsructor --> it has the same name as class
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please input your name : ");
        name = input.nextLine(); //read user input and store into variable name
        System.out.print("Please input your age: ");
        age = input.nextInt();
        System.out.print("Please input your height : ");
        height = input.nextDouble();
        System.out.print("Please input your grade : ");
        grade = input.next().charAt(0);
        
        System.out.println(name + ", you are " + age + " years old.");
        System.out.println("Your height is " + height + " and your grade is " + grade);
    }
    
}

