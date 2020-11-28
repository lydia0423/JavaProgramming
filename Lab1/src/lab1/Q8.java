package lab1;
import java.util.Scanner;

public class Q8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double futureInvestmentVal;
        double investmentAmount;
        double monthlyInterestRate;
        int numOfYears;
        
        System.out.print("Please enter your investment amount: ");
        investmentAmount = input.nextDouble();
        System.out.print("Please enter your monthly interest rate: ");
        monthlyInterestRate = input.nextDouble();
        System.out.print("Please enter your number of years: ");
        numOfYears = input.nextInt();
        
        futureInvestmentVal = investmentAmount * Math.pow(1 + monthlyInterestRate, numOfYears * 12);
        
        System.out.println("Future Investment Value = " + futureInvestmentVal);
    }
    
}
