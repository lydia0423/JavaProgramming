package lab7;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter; 
import java.io.IOException;
import java.util.Scanner;

class Loan{
    private double annualInterestRate, loanAmount, monthlyPayment, totalPayment;
    private int numberOfYears;
    private String loanDate;
    
    Loan(double annualIR, double loanA, int y, String d){
        annualInterestRate = annualIR;
        loanAmount = loanA ;
        numberOfYears = y;
        loanDate = d;
    }
    
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
    
    public int getNumberOfYears(){
        return numberOfYears;
    }
    
    public double getLoanAmount(){
        return loanAmount;
    }
    
    public String getLoanDate(){
        return loanDate;
    }
    
    public void setAnnualInterestRate(double aInterestRate){
        annualInterestRate =  aInterestRate;
    }
    
    public void setNumberOfYears(int y){
        numberOfYears = y;
    }
    
    public void setLoanAmount(double lAmount){
        loanAmount = lAmount;
    }
    
    public double getMonthlyPayment(){
        return monthlyPayment;
    }
    
    public double getTotalPayment(){
        return totalPayment;
    }
    
    public void display(){
        System.out.println("Annual Interest: " + annualInterestRate + 
        "\nLoan Amount Given: " + loanAmount + "\nNumber of Years: " + numberOfYears + 
        "\nLoan Date: " + loanDate +
        "\nMonthly Payment: " + (monthlyPayment = (loanAmount * annualInterestRate * numberOfYears) / (numberOfYears * 12)) + 
        "\nTotal Payment: " + (totalPayment = monthlyPayment * 12 * numberOfYears));
    }
}

public class Lab7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Loan obj1 = new Loan(2.2, 46800, 5, "20-12-20");
        
        try
        {
        FileWriter fw = new FileWriter("loan.txt", true); 
        BufferedWriter bw = new BufferedWriter(fw); 
        bw.write(String.valueOf(obj1.getAnnualInterestRate()));
        bw.newLine();
        bw.write(String.valueOf(obj1.getLoanAmount()));
        bw.newLine();
        bw.write(String.valueOf(obj1.getNumberOfYears()));
        bw.newLine();
        bw.write(obj1.getLoanDate());
        bw.newLine();
        bw.close();
        
        System.out.println("Date written to the file.");
        }
        catch(IOException ex)
        {
           System.out.println("Unable to create file due to + " + ex); 
        }
        
        System.out.println("**********************\nRead file content");
        File file = new File("loan.txt"); 
        try
        {
            Scanner inputFile = new Scanner(file);
            while (inputFile.hasNext()){
                double annualIR = inputFile.nextDouble();
                double loanA = inputFile.nextDouble();
                int y = inputFile.nextInt();
                String d = inputFile.nextLine();
                inputFile.nextLine();
                
                Loan newObj = new Loan (annualIR, loanA, y, d);
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
