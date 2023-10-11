// Objective
// In this challenge, we will use loops to do some math. Check out the Tutorial tab to learn more.

// Task
// Given an integer, n, print its first 10 multiples. Each multiple n * i (where 1 <= i <= 10) 
// should be printed on a new line in the form: n x i = result.

// Example
// n = 3
// The printout should look like this:
// 3 x 1 = 3
// 3 x 2 = 6
// 3 x 3 = 9
// 3 x 4 = 12
// 3 x 5 = 15
// 3 x 6 = 18
// 3 x 7 = 21
// 3 x 8 = 24
// 3 x 9 = 27
// 3 x 10 = 30

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

// https://www.geeksforgeeks.org/java-string-format-method-with-examples/ (method can take various types and then 
// is positional paired once the string concludes, kinda like a timestamp for formatting)

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        bufferedReader.close();
        int counter = 1;
        // can format a string similar to python f-string as follows to output str of int operations
        while(counter <= 10){
            System.out.println(String.format("%d x %d = %d", n, counter, n * counter));
            counter ++;
        }
    }
}
