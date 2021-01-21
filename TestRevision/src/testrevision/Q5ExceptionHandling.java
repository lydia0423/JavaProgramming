/*Define a class Circle which has radius and (static)numberOfObjects as its attributes.
- - A constructor which calls setRadius method to assign value to attribute radius. 
setRadius  method throws IllegalArgumentException to ensure radius value is greater than 0. 
It also increases numberOfObject if object can be created. 
- Another method findArea to calculate the area of the object. 

Create a main program to construct objects of Circle and display the number of objects created and its radius.

 */
package testrevision;

class Circle{
    private double radius;
    static int numOfObject=0;
    
    Circle(){
        radius = 1.0;
    }
    
    Circle(double r){
        setRadius(r);
        numOfObject++;
        System.out.println("Object created.");
    }
    
    double getRadius(){
        return radius;
    }
    
    void setRadius(double newRadius){
        if(newRadius>=0) {
            radius = newRadius;
        } else {
            throw new IllegalArgumentException ("Radius cannot be negative");
        }
    }
    
    public static int getNumOfObject(){
        return numOfObject;
    }
    
    double findArea(){
        return radius * radius * 3.142;
    }
}

public class Q5ExceptionHandling {
    public static void main(String[] args) {
        try {
           Circle obj1 = new Circle(5);
           Circle obj3 = new Circle(10);
           Circle obj2 = new Circle(-5);
           Circle obj4 = new Circle();
           
           //test objects creation
           System.out.println("Area of obj1 : " +obj1.findArea());
           System.out.println("Area of obj3 : " +obj3.findArea());
           System.out.println("Area of obj4 : " +obj4.findArea());
       }
       catch (IllegalArgumentException ex){
           System.out.println("Message :"+ex);
       }
       finally{
           System.out.println("Number of objects created :"+Circle.getNumOfObject());
       }
    }
    
}
