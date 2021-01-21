package lab8;

class Circle{
    private double radius;
    static int numberOfObjects = 0;
    protected double area;
    protected double pi = 3.142;
    
    public void setRadius(double r){
        radius = r;
        
        try
        {
            if(r < 0){
                System.out.print("The radius cannot be less than 0");
            }else{
                numberOfObjects ++;
                System.out.println("Object created");
            }
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    
    double findArea(){
        return area = radius * radius * pi;
    }
    
    public void display(){
        System.out.println("The radius of the circle is " + radius + " and the number of objects created is " + numberOfObjects);
    }
    
}

public class Lab8 {
    public static void main(String[] args) {
       Circle obj1 = new Circle();
       obj1.setRadius(-5.0);
       obj1.display();
       System.out.println("Area of object is " + obj1.findArea());
       
    }
    
}
