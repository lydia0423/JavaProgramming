package lab5;
import java.util.Scanner;

class Pal{
    //attributes to declare private access
    private String firstName, lastName;
    private int age;
    
    //assign value to attributes (attributeName = parameters)
    Pal(String fn, String ln){ 
        firstName = fn;
        lastName = ln;
    }
    
    //multiple constructor = constructor overloading
    Pal(String fn, String ln, int a){
        firstName = fn;
        lastName = ln;
        age = a;
    }
    
    //set(mutator)- assign value to attributes
    //get(accessor)- extract value of attributes
    public void setAge(int a){
        age = a;
    }
    
    public int getAge(){
        return age;
    }
    
    //method to display data
    public void display(){
        System.out.println("First Name: " + firstName + "\nLast Name: " + lastName + "\nAge: " + age);
    }
}

public class testPal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first name: ");
        String fnm = input.next();
        System.out.println("Enter last name: ");
        String lnm = input.next();
        //create object in main method
        //className objectName = new constrcutor();
        
        //fucntion call
        Pal obj1 = new Pal(fnm, lnm);
        Pal obj2 = new Pal("Holly", "Gabrielle", 23);
        Pal obj3 = new Pal("John", "Smith", 40);
        
        //object call method display
        obj1.display();
        obj2.display();
        obj3.display();
        
        obj1.setAge(19);
        System.out.println("After exceuting set method");
        System.out.println("Age of obj1: " + obj1.getAge());
        
        
    }
    
}
