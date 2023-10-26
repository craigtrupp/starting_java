/*
Task
The AdvancedArithmetic interface and the method declaration for the abstract divisorSum(n) method are provided for you in the editor below.

Complete the implementation of Calculator class, which implements the AdvancedArithmetic interface. The implementation for the divisorSum(n) method must return the sum of all divisors of n.

Example
n = 25
The divisors of 25 are 1,5,25 . Their sum is .


The divisors of  are  and their sum is .
*/


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
        List<Integer> uniqueDivisors = new ArrayList<>(new LinkedHashSet<>(divisors));
        System.out.println(uniqueDivisors);
        int divisorTotal = 0;
        for(int divisor : uniqueDivisors){
            divisorTotal += divisor;
        }
        return divisorTotal;
        
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

/*
Output of Test : 20
[1, 20, 2, 10, 4, 5, 5, 4]
[1, 20, 2, 10, 4, 5]
I implemented: AdvancedArithmetic
42
*/

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
        //System.out.println(divisors);
        List<Integer> uniqueDivisors = new ArrayList<>(new LinkedHashSet<>(divisors));
        //System.out.println(uniqueDivisors);
        int divisorTotal = 0;
        for(int divisor : uniqueDivisors){
            divisorTotal += divisor;
        }
        return divisorTotal;
        
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