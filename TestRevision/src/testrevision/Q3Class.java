/*3.Design and implement a class to represent a bank account. Include the following members:
    Attributes
    -Name, Account Number, Type of account, Balance amount in account
    Methods
    Constructor - to assign initial values
    To deposit amount
    To withdraw amount after checking balance
    To display name and balance

Create an object in the main class to access these methods and members.
 */

package testrevision;
import java.util.Scanner;

class Account{
    private String name, accountNumber, accountType;
    private double accountBalance, withdrawAmount, depositAmount;
    
    Account(String n, String aNum, String aType, double  aBalance){
        name = n;
        accountNumber = aNum;
        accountType = aType;
        accountBalance = aBalance;
    }
    
    public void setWithdraw(double withdraw){
        withdrawAmount = withdraw;
        accountBalance = accountBalance - withdraw;
    }
    
    public void setDeposit(double deposit){
        depositAmount = deposit;
        accountBalance = accountBalance + deposit;
    }
    
    public void display(){
        System.out.println(
        "Name: " + name +
        "\nAccount Number: " + accountNumber +
        "\nAccount Type: " + accountType +
        "\nAccount Balance: " + accountBalance);
    }
}

public class Q3Class {
    public static void main(String[] args) {
        System.out.println("------------Account Details------------");
        Account obj1 = new Account("Lydia", "151156783489","Deposit/Investment Account", 100.0);
        
        obj1.setDeposit(100);
        obj1.setWithdraw(20);
        obj1.display();
        
        
        
    }
    
}
