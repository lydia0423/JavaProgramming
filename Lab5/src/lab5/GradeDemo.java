package lab5;

class StudentGrade{
    private String IDNum, name, grade;
    private int testScore, possiblePoints;
    private double percentage;
    
    StudentGrade(String i, String n, int s, int p){
        IDNum = i;
        name = n;
        testScore = s;
        if(p == 0)
            possiblePoints = 1;
        else
            possiblePoints = p;
    }
    
    public double getCalculatePercentage(){
        percentage = testScore / possiblePoints;
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
        System.out.println("ID Number: " + IDNum + "\nStudent Name: " + name + "\nTestScore: " + testScore + "\nPossible Points: " + possiblePoints);
    }
    
}
public class GradeDemo {
    public static void main(String[] args) {
        StudentGrade obj1 = new StudentGrade("TP054547", "Lydia", 100, 0);
        
        obj1.display();
        System.out.println("Percentage: " + obj1.getCalculatePercentage() + "\nGrade: " + obj1.getGrade());
    }
    
}
