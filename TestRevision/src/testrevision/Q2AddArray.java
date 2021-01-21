/*2.Write a program that will read 10 numbers from the user and store them in an
array called num[]. The program should determine how many of the numbers entered 
by the user are even and odd.

	Sample input-output :
	Key in 10 numbers : 1 2 3 4 5 6 7 8 9 10
	The total number of even numbers entered are : 5
	The total number of odd numbers entered are : 5

 */
package testrevision;
import java.util.Scanner;

public class Q2AddArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int num[] = new int[10];
        int i;
        int odd = 0;
        int even = 0;
        
        for(i = 0; i < num.length; i++){
            System.out.print("Enter 10 numbers: ");
            num[i] = input.nextInt();
            
            if(num[i] % 2 == 0){
                even++;
            }else{
                odd++;
            }   
        }
        
        System.out.println("The total number of even numbers entered are: " + even);
        System.out.println("The total number of odd numbers entered are: " + odd);
        
    }
    
}
