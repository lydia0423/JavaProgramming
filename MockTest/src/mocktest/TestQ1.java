package mocktest;

import java.util.Scanner;

public class TestQ1 {
    public static void main(String[] args) {
       /*boolean test = false;
       String[] myArr = {"kick", null, "pick"};
       if((myArr[1] == null ) || (myArr[1].length() == 0)){
           System.out.print("90");
       }
       
       if(myArr[2] == null && (test & true)){
           System.out.print("02");        
       }
       
       
       if((myArr[0].length()) > (myArr[2].length())){
           System.out.print("03");
       }
       
       
       if(myArr[1](test)  (test)){
           System.out.print("01");
              
       }*/
       
        int a, i=0;
        int [] num = new int [100];
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        
        do{
            System.out.print("Please enter an integer :");
            a = sc.nextInt();
            if (a <= 999)
            {
                num[i]=a;
                sum += a;
            }
        }while(a>0);
        System.out.print("Sum : " + sum);
        
    }

                    
            
    }
      
   
   
