package lab3;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int counter = 0;
        double testScore = 0, minScore = 0,
               maxScore = 0,
               avgScore = 0;
   
        do {            
            System.out.print("Enter your test score: ");
            testScore = input.nextDouble();
            
            if(testScore > 0){
                if(testScore > maxScore) {
                    maxScore = testScore;
                } 
                if (testScore < minScore) {
                    minScore = testScore;
                }
                avgScore += testScore;
            }
            counter++;
        } while (testScore >= 0);
       
       avgScore /= counter;
       System.out.println("The minimum score is: " + minScore);
       System.out.println("The maximum score is: " + maxScore);
       System.out.println("The average score is: " + avgScore);

    
    }
}
