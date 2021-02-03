/*7.Write a program that reads a set of integers, and then prints the sum of the even and odd integers. */
package testrevision;

public class LoopsQ7 {
    public static void main(String[] args) {
        int sumOdd = 0;
        int sumEven = 0;
        
        for(int i = 1; i <= 10; i ++){
            if(i % 2 == 0){
                sumEven += i;
            }else{
                sumOdd += i;
            }
        }
        
        System.out.println("The sum of odd numbers: " + sumOdd);
        System.out.println("The sum of even numbers: " + sumEven);
    }
    
}
