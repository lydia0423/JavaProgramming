/*1.Create a Pal class with data members of first name, last name, and age. 
Include a method to output a Pal’s data. Create constructors to takes arguments and assign to data members.
Write a main ( ) program that declares three Pal objects to which you assign data. Display each Pal.
 */

package testrevision;

class Pal{
    private String firstName, lastName;
    private int age;
    
    Pal(String fn, String ln, int a){
        firstName = fn;
        lastName = ln;
        age = a;
    }
    
    public void display(){
        System.out.println("First Name: " + firstName + "\nLast Name: " + lastName + "\nAge: " + age);
    }
}

public class Q1Class {
    public static void main(String[] args) {
        Pal obj1 = new Pal("Lydia", "Foo", 20);
        
        obj1.display();
    }
    
}
