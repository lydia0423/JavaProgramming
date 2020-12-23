package lab7;
import java.io.BufferedWriter;
import java.io.File; //used for read and write
import java.io.FileNotFoundException;
import java.io.FileWriter; // used to write
import java.io.IOException;
import java.util.Scanner;

class Person{
    private String name;
    private int age;
    private double cpa;
    
    Person(String n, int a, double c){
        name = n;
        age = a;
        cpa = c;
    }
    
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
    public double getCPA(){
        return cpa;
    }
    
    public void display(){
        System.out.println(name + " you are " + age + " years old and your CPA is " +cpa);
    }
}

public class testWrite {
    public static void main(String[] args) {
        Person obj1 = new Person("Jack", 20, 3.95);
        
        try
        {
        FileWriter fw = new FileWriter("person.txt", true); //true: will create a person.txt if there is not exist in the folder, if exist in the folder, it will add the new record in it
        //bufferedwriter require the string data type
        BufferedWriter bw = new BufferedWriter(fw); //to take the data and write into the file
        bw.write(obj1.getName()); //bw.write("Jack");
        bw.newLine();
        bw.write(String.valueOf(obj1.getAge()));
        bw.newLine();
        bw.write(String.valueOf(obj1.getCPA()));
        bw.newLine();
        bw.close();
        
        System.out.println("Date written to the file.");
        }
        catch(IOException ex)
        {
           System.out.println("Unable to create file due to + " + ex); 
        }
        
        System.out.println("**********************\nRead file content");
        File file = new File("person.txt"); //creating a file object
        try
        {
            Scanner inputFile = new Scanner(file);//open a file named person.txt
            while (inputFile.hasNext()){
                String n = inputFile.nextLine();// newLine()-used to read the whole line
                int a = inputFile.nextInt();
                double c = inputFile.nextDouble();
                inputFile.nextLine();
                
                Person newObj = new Person (n,a,c);
                newObj.display();
            }
            inputFile.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Unable to open file due to " +ex);
        }
 
    }
    
}
