package lab4;
import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int i;
        int[] A = new int [6];
        int[] B = new int [6];
        int[] C = new int [5];
        int[] D = new int [4];
        int sum=0;
        
        //A-Obtaining number sequence
        for(i=0; i<A.length; i++)
        {
            System.out.print("Enter 6 numbers: ");
            A[i]=input.nextInt();
            
        }
        
        //A-Display number in forward direction
        for(i=0; i<A.length; i++)
        {
            System.out.println("A["+i+"] = " + A[i]);
        }
        

        //B-Compute and print arrays B, where B[i]=A[0]+A[1]+...+A[i]
        for(i=0; i<6; i++)
        {
            sum += A[i];
            System.out.println("B["+i+"] = " + sum);
        }
        
        //C-Compute pairwise differences : C[i] = A[i+1]-A[i]
        for(i=0; i<A.length-1; i++)
        {
            C[i] = (A[i+1] - A[i]);
            System.out.println("C["+i+"] = " + C[i]);
        }
        
        //D-Compute three-way averages : D[i]=(A[i]+A[i+1]+A[i+2])/3 
        for(i=0; i<A.length-2; i++)
        {
            D[i] = (A[i]+A[i+1]+A[i+2])/3 ;
            System.out.println("D["+i+"] = " + D[i]);
        }
            
    }
    
}

