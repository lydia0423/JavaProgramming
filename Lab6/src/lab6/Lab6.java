package lab6;
import java.util.Scanner;

class Account{
    protected double accountBalance, deposit, withdraw, balance;
    
    Account(double accBlc){
        accountBalance = accBlc;
        
        if(accBlc >= 0)
            accBlc = accountBalance;
        else{
            accBlc = 0;
            System.out.println("Invalid initial balance");
        }   
    }
    
    public void deposit(double d){
        accountBalance += d;
        System.out.println("RM" + d + " has been deposited into your account");
        System.out.println("Your new balance is RM" + accountBalance);
    }
    
    public void withdraw(double w){
        withdraw = w;
        
        if(w > accountBalance)
            System.out.print("Withdrawal amount exceeded account balance");
        else{
           accountBalance = accountBalance - w;
           System.out.println("RM" + w + " has been withdrawn");
           System.out.println("Your new balance is RM " + accountBalance);
        }
    }
    
    public double getBalance(){
        return accountBalance;
    } 
    
    public double setBalance(double b){
        accountBalance = b;
        return accountBalance;
    }
    
}

class SavingAccount extends Account{
    private double interestRate, interestEarned;
    
    SavingAccount(double accBlc, double interestRate){
        super(accBlc);
        this.interestRate = interestRate;
    }
    
    public double CalculateInterest(){
        interestEarned = (interestRate*accountBalance);
        return interestEarned;
    }
    
}

public class Lab6 {
    public static void main(String[] args) {
        System.out.println("Saving Account");
        SavingAccount obj1 = new SavingAccount(500, 0.05);
        System.out.println("The current balance is: RM" + obj1.getBalance());
        obj1.deposit(obj1.CalculateInterest());
        
        System.out.println();
        //Testing the Account object
        System.out.println("Account");
        Account newAccount = new Account(1000);
        System.out.println("The balance is: RM" + newAccount.getBalance());
        newAccount.deposit(10);
        newAccount.withdraw(500);
        newAccount.setBalance(1000);
       
      
    }
    
}
