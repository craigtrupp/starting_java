


import java.io.*;
import java.util.*;

interface AdvancedArithmetic{
   int divisorSum(int n);
}
class Calculator implements AdvancedArithmetic {
    public int divisorSum(int n) {
        // Sq root of n (rounded to the highest integer will give the max divisible to check by)
        int maxDivisibleIterator = (int) Math.ceil(Math.sqrt(n));
        List<Integer> divisors = new ArrayList<Integer>();
        divisors.add(1);
        divisors.add(n);
        for(int i = 2; i <= maxDivisibleIterator; i++){
            if(n % i == 0){
                int nonNMultiple = (int) n / i;
                divisors.add(i);
                divisors.add(nonNMultiple);
            }
        }
        System.out.println(divisors);
        return 5;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        
      	AdvancedArithmetic myCalculator = new Calculator(); 
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
    }
}