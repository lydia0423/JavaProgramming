package mocktest;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        int a, i=0;
        int [] num = new int [100];
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("Please enter an integer :");
            a = input.nextInt();
            if (a > 0)
            {
                num[i]=a;
                i++;
            }
        }while(a>0);
            System.out.print("Numbers entered : ");
        
            for (int j = 0; j < i; j++) {
                System.out.print(num[j] +"\t");
            }
    }
        
}
    
