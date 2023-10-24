/*
Objective
Yesterday's challenge taught you to manage exceptional situations by using try and catch blocks. In today's challenge, you will practice throwing and propagating an exception.

Task
Write a Calculator class with a single method: int power(int,int). 
The power method takes two integers, n and p, as parameters and returns the integer result of n^p. 
If either n or p is negative, 
    - then the method must throw an exception with the message: **n and p should be non-negative.**

Note: Do not use an access modifier (e.g.: public) in the declaration for your Calculator class.

Sample Input
4
3 5
2 4
-1 -2
-1 3

Sample Output
243
16
n and p should be non-negative
n and p should be non-negative
*/

// Solution : imported Math library for access to power function and threw IllegalArgument Exception for simple Calculator class
import java.util.*;
import java.io.*;
import java.lang.Math;

//Write your code here
class Calculator {
    public int power(int n, int p){
        if(n == 0 && p == 0){
            throw new IllegalArgumentException("Please provide a valid integer greater than zero");
        } else if (n < 0 || p < 0){
            throw new IllegalArgumentException("n and p should be non-negative");
        }
        return (int) Math.pow(n, p);
    }
}

class Solution{

    public static void main(String[] args) {
    
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
        
            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();
            try {
                int ans = myCalculator.power(n, p);
                System.out.println(ans);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        in.close();
    }
}
