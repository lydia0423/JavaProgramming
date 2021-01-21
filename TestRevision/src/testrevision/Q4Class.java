/*4.Create a class named StudentGrade. Include data members ID number, name, 
test score, possible points and grade. Create a constructor that requires the ID,
name, test score and allows a fourth parameter that holds possible test points (1-100).
If a 0 value is passed for possible points, set the possible points to 1. 
Create a method to calculate the student’s percentage (divides score by possible 
points) and assigns a grade based on: 90% and above (A), 80% and above (B), 70% 
and above (C), 60% and above (D), otherwise (F). 
Create a main( ) program that displays StudentGrade objects to test a variety of 
scores and possible point values. 

 */
package testrevision;

class StudentGrade{
    private String studentID, name, grade;
    private double testScore, possibleTestPoint, percentage;
    
    StudentGrade(String id, String n, double results, double possiblePoint){
        studentID = id;
        name = n;
        testScore = results;
        
        if(possiblePoint == 0)
            possibleTestPoint = 1;
        else
           possibleTestPoint = possiblePoint;
    }
    
    public double getCalculatePercentage(){
        percentage = testScore / possibleTestPoint;
        return percentage;
    }
    
    public String getGrade(){
        
        if(testScore >= 90 && testScore <=100)
            return "A";
        else if(testScore >= 80 && testScore <= 89)
            return "B";
        else if(testScore >= 70 && testScore <= 79)
            return "C";
        else if(testScore >= 60 && testScore <= 69)
            return "D";
        else
            return "E";
    }
    
    public void display(){
        System.out.println("Student ID: " + studentID + 
                "\nStudent Name: " + name + 
                "\nTestScore: " + testScore + 
                "\nPossible Points: " + possibleTestPoint);
    }


}

public class Q4Class {
    public static void main(String[] args) {
        StudentGrade obj1 = new StudentGrade("TP054547", "Lydia", 100, 0);
        
        obj1.display();
        System.out.println("Percentage: " + obj1.getCalculatePercentage() + "\nGrade: " + obj1.getGrade());
    }

}
    

