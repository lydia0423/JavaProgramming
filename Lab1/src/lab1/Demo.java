package lab1;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ft;
        double m;
        
        System.out.print("Input in ft: ");
        ft = input.nextInt();
        m = ft * 0.305;
        
        System.out.println(ft + " feet = " + m  + " metres");
        //System.out.println(ft + " feet = " + (ft * 0.305)  + " metres");
    }
    
}
