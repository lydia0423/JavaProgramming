package lab5;
import java.util.Scanner;

class Account{
    private String name, typeOfAccount;
    private int accountNum;
    private double balanceAmount, deposit, withdraw;
    
    Account(String n, String t, int num, int balc){
        name = n;
        typeOfAccount = t;
        accountNum = num;
        balanceAmount = balc;
    }
    
    public void setDeposit(int d){
        deposit = d;
        balanceAmount = balanceAmount + d;
    }
    
    public void setWithdraw(double w){
        withdraw = w;
        balanceAmount = balanceAmount - w;
    }
    
    /*public void getWithdraw(){
        return withdraw;
    }*/
    
    public void display(){
        System.out.println("Name:" + name + "\nBalance Amount: " + balanceAmount);
    }
}
public class BankAccountDemo {
    public static void main(String[] args) {
        Account obj1 = new Account("Lydia", "Saving Account", 1234567890, 100);
        
        obj1.setDeposit(100);
        obj1.setWithdraw(20);
        obj1.display();
            
    }
    
}
