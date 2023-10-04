// https://www.hackerrank.com/challenges/30-hello-world/tutorial

// Objective
// In this challenge, we review some basic concepts that will get you started with this series. You will need to use the same (or similar) syntax to 
// read input and write output in challenges throughout HackerRank. Check out the Tutorial tab for learning materials and an instructional video!

// Task
// To complete this challenge, you must save a line of input from stdin to a variable, print Hello, World. on a single line, and finally print the value of your variable on a second line.

// You've got this!

// Note: The instructions are Java-based, but we support submissions in many popular languages. You can switch languages using the drop-down menu above your editor, 
// and the inputString variable may be written differently depending on the best-practice conventions of your submission language.

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello, World.");
        String inputString = "";
        do {
            // System.out.println(scan.next()); - prints out each line
            inputString += ' ' + scan.next();
            
        } while(scan.hasNext());
        scan.close();
        System.out.println(inputString.trim());
    }
}