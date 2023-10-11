// Objective
// Today we will expand our knowledge of strings, combining it with what we have already learned about loops. Check out the Tutorial tab for learning materials and an instructional video.

// Task
// Given a string, S, of length N that is indexed from 0 to N-1, print its even-indexed and odd-indexed characters as 2 space-separated strings on a 
// single line (see the Sample below for more detail).

// Note: 0 is considered to be an even index.

// Example
// s = adbecf

// Print abc def

// Input Format

// The first line contains an integer,  (the number of test cases).
// Each line  of the  subsequent lines contain a string, 

// Sample Input
// 2
// Hacker
// Rank

// Sample Output
// Hce akr
// Rn ak

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int counter = 0;
        do {
            String input = bufferedReader.readLine().trim();
            String evenChars = "";
            String oddChars = "";
            for (int i = 0; i < input.length(); i++){
                if (i % 2 == 0) {
                    evenChars += input.charAt(i);
                } else {
                    oddChars += input.charAt(i);
                }
            }
            System.out.println(String.format("%s %s", evenChars, oddChars));
            counter ++;
        } while (counter < n);
        //System.out.println(n);
    }
}