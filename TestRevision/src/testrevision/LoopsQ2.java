/*Write a program to calculate the sum of first 10 natural number*/
package testrevision;

public class LoopsQ2 {
    public static void main(String[] args) {
        int sum =0;
        
        for(int i = 1; i <= 10; i++){
            sum += i;
        }
        
        System.out.print("The sum of first 10 natural number: " + sum);
    }
    
}
