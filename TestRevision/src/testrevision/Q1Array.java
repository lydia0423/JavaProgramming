/*Read a sequence of 6 numbers and store them in an array A and perform the following operations:
        a)Compute & print running sums in forward directions. Specifically, compute and print arrays B, where  B[i]=A[0]+A[1]+...+A[i], 
        B[0] = A[0]
        B[1] = A[0] + A[1]
        B[2] = A[0] + A[1] + A[2]

        b)Compute pairwise differences : C[i] = A[i+1]-A[i].
        C[0] = A[1] – A[0]
        C[1] = A[2] – A[1]

        c)Compute three-way averages : D[i]=(A[i]+A[i+1]+A[i+2])/3 
        D[0] = (A[0] + A[1] + A[2])/3
        D[0] = (A[1] + A[2] + A[3])/3
        D[0] = (A[2] + A[3] + A[4])/3

 */
package testrevision;
import java.util.Scanner;

public class Q1Array {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int i;
        int sum = 0;
        int[] A = new int[6];
        int[] B = new int[6];
        int[] C = new int[5];
        int[] D = new int[4];
        
        for(i = 0; i < A.length; i++){
            System.out.print("Enter 6 numbers: ");
            A[i] = input.nextInt();
        }
        
        //a)Compute & print running sums in forward directions.
        for(i = 0; i < A.length; i++){
            System.out.println("A["+i+"] = " + A[i]);
        }
        
        for(i = 0; i < 6; i++){
            sum += A[i];
            System.out.println("B["+i+"] = " + sum);
        }
        
        //b)Compute pairwise differences : C[i] = A[i+1]-A[i].
        for(i = 0; i < A.length -1 ; i++){
            C[i] = (A[i+1] - A[i]);
            System.out.println("C["+i+"] = " + C[i]);
        }
        
        //c)Compute three-way averages : D[i]=(A[i]+A[i+1]+A[i+2])/3
        for(i = 0; i < A.length - 2; i++){
            D[i] = (A[i]+A[i+1]+A[i+2])/3;
            System.out.println("D["+i+"] = " + D[i]);
        }
        
    }
    
}
