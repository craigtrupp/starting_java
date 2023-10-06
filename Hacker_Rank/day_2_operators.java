// Objective
// In this challenge, you will work with arithmetic operators. Check out the Tutorial tab for learning materials and an instructional video.

// Task
// Given the meal price (base cost of a meal), tip percent (the percentage of the meal price being added as tip), and tax percent 
// (the percentage of the meal price being added as tax) for a meal, find and print the meal's total cost. Round the result to the nearest integer.

// Example
// mealcost = 100
// tippercent = 15
// taxpercent = 8

// A tip of 15% * 100 = 15, and the taxes are 8% * 100 = 8. Print the value 123 and return from the function.

// Function Description
// Complete the solve function in the editor below.

// solve has the following parameters:

// int meal_cost: the cost of food before tip and tax
// int tip_percent: the tip percentage
// int tax_percent: the tax percentage
// Returns The function returns nothing. Print the calculated value, rounded to the nearest integer.

// Note: Be sure to use precise values for your calculations, or you may end up with an incorrectly rounded result.

// Sample Input
// 12.00
// 20
// 8

// Output
// 15

// Notes 
// https://stackoverflow.com/questions/4931892/why-does-the-division-of-two-integers-return-0-0-in-java (division zero handling - similar to sql)
// https://stackoverflow.com/questions/153724/how-to-round-a-number-to-n-decimal-places-in-java (round in java - man ... this is hell haha)
// https://stackoverflow.com/questions/2654839/rounding-a-double-to-turn-it-into-an-int-java - Rounding a double to turn to int

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'solve' function below.
     *
     * The function accepts following parameters:
     *  1. DOUBLE meal_cost
     *  2. INTEGER tip_percent
     *  3. INTEGER tax_percent
     */

    public static void solve(double meal_cost, int tip_percent, int tax_percent) {
    // Write your code here
        double tip_amount = (double)Math.round(((double) tip_percent) / 100 * meal_cost * 100d) / 100d;
        double tax_amount = (double)Math.round((double) tax_percent / 100 * meal_cost * 100d) / 100d;
        System.out.println(tip_amount);
        System.out.println(tax_amount);
        System.out.println(meal_cost + tip_amount + tax_amount); // all doubles
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        double meal_cost = Double.parseDouble(bufferedReader.readLine().trim());

        int tip_percent = Integer.parseInt(bufferedReader.readLine().trim());

        int tax_percent = Integer.parseInt(bufferedReader.readLine().trim());

        Result.solve(meal_cost, tip_percent, tax_percent);

        bufferedReader.close();
    }
}

// My Output 
// 2.4
// 0.96
// 15.36

// Now just need to round the value (total_cost down to the nearest dollar)

// Answer
class Result {

    /*
     * Complete the 'solve' function below.
     *
     * The function accepts following parameters:
     *  1. DOUBLE meal_cost
     *  2. INTEGER tip_percent
     *  3. INTEGER tax_percent
     */

    public static void solve(double meal_cost, int tip_percent, int tax_percent) {
    // Write your code here
        double tip_amount = (double)Math.round(((double) tip_percent) / 100 * meal_cost * 100d) / 100d;
        double tax_amount = (double)Math.round((double) tax_percent / 100 * meal_cost * 100d) / 100d;
        double total_cost = meal_cost + tip_amount + tax_amount;
        int total_cost_nearest_int = (int) Math.round(total_cost);
        System.out.println(total_cost_nearest_int);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        double meal_cost = Double.parseDouble(bufferedReader.readLine().trim());

        int tip_percent = Integer.parseInt(bufferedReader.readLine().trim());

        int tax_percent = Integer.parseInt(bufferedReader.readLine().trim());

        Result.solve(meal_cost, tip_percent, tax_percent);

        bufferedReader.close();
    }
}