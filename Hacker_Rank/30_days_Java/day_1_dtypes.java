// Objective
// Today, we're discussing data types. Check out the Tutorial tab for learning materials and an instructional video!

// Task
// Complete the code in the editor below. The variables i, d, and s are already declared and initialized for you. You must:

// Declare 3 variables: one of type int, one of type double, and one of type String.
// Read 3 lines of input from stdin (according to the sequence given in the Input Format section below) and initialize your 3 variables.
// Use the + operator to perform the following operations:
//     Print the sum of i plus your int variable on a new line.
//     Print the sum of d plus your double variable to a scale of one decimal place on a new line.
//     Concatenate s with the string you read as input and print the result on a new line.

// Input Format

// The first line contains an integer that you must sum with i.
// The second line contains a double that you must sum with d.
// The third line contains a string that you must concatenate with s.


// 12
// 4.0
// is the best place to learn and practice coding!

// Output Format

// Print the sum of both integers on the first line, the sum of both doubles (scaled to 1 decimal place) on the second line, and then the two concatenated strings on the third line.

// Expected Output
// 16
// 8.0
// HackerRank is the best place to learn and practice coding!

import java.io.*;
import java.util.*;
import java.lang.reflect.Array;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        Object[] objects = new Object[3]; // .. Setting null type variables
        // Using an Array methods to set the array value at index i
        // https://stackoverflow.com/questions/23957581/java-array-with-multiple-data-types : multiple data types support
        for (int i = 0; i < objects.length; i++){
            Array.set(objects, i, scan.nextLine()); // method off class to mutate object at index i
            //System.out.println(arr);
            Object o = objects[i];
            System.out.println(o);
        }
        System.out.println(objects[0].getClass().getName());
        System.out.println(objects[1].getClass().getName());
    }
}

// My Output to date

// 12
// 4.0
// is the best place to learn and practice coding!
// java.lang.String
// java.lang.Stri


// Whole Solution 
// Note line 85 for the requirement of setting the object type to a string before I could change and get the desired output (int + float default to float so had to mutate float for first output)
import java.io.*;
import java.util.*;
import java.lang.reflect.Array;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        Object[] objects = new Object[3]; // .. Setting null type variables
        // Using an Array methods to set the array value at index i
        // https://stackoverflow.com/questions/23957581/java-array-with-multiple-data-types : multiple data types support
        for (int i = 0; i < objects.length; i++){
            Array.set(objects, i, scan.nextLine()); // method off class to mutate object at index i
            Object o = objects[i];
            //System.out.println(o);
        }
        String[] ST1 = new String[]{(String)objects[0], (String)objects[1], (String)objects[2]}; // for object type this is the only way I could set each to a string that I could then mutate
        int i = 4;
        System.out.println(i + Integer.parseInt(ST1[0]));
        System.out.println((float)i + Float.parseFloat(ST1[1])); 
        System.out.println("HackerRank " + ST1[2]);
    }
}