/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocktest;

class Test{
    public static void main(String[] args) {
        Count myCount = new Count();
        int times = 0;
        
        for (int i = 0; i < 10; i++){
            increment(myCount, times);
            
            System.out.println("myCount.count = " + myCount.count);
            System.out.println("times = " + times);
            
        }
    }
    
    public static void increment(Count c, int times){
        c.count++;
        times++;
    }
        
    
}
    
class Count{
    int count;
    
    Count(int c){
        count = c;
    }
    
    Count(){
        count = 1;
    }
}

