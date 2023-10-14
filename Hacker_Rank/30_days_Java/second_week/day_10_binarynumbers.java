/*
Task
Given a base-10 integer, n, convert it to binary (base-2). Then find and print the base-10 integer denoting the maximum number of consecutive 1's in n's binary representation. 
When working with different bases, it is common to show the base as a subscript.

Example:
n = 125
The binary representation of 125(sub10) is 1111101(sub2 - this mean the base) . In base 10, there are 5 and 1 consecutive ones in two groups. 
Print the maximum, 5.

*/

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



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String binaryString = Integer.toBinaryString(n);
        System.out.println(String.format("Base-10 value of : %d is equal to %s", n, binaryString));
        for (char ch: binaryString.toCharArray()){
            System.out.println(ch);
        }
        bufferedReader.close();
    }
}


/*
-- First Read out 
Base-10 value of : 5 is equal to 101
1
0
1
*/

/*
-- Oh ... hi regex
Kinda just hacked till right 
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String binaryString = Integer.toBinaryString(n);
        System.out.println(String.format("Base-10 value of : %d is equal to %s", n, binaryString));
        String consecutive1s = "((1){1,})";
        Pattern p = Pattern.compile(consecutive1s);
        Matcher matches = p.matcher(binaryString);
        System.out.println(matches);
        if(matches.find()){
            System.out.println(matches.groupCount());
        }
        bufferedReader.close();
    }
}
/*
Base-10 value of : 5 is equal to 101
java.util.regex.Matcher[pattern=((1){1,}) region=0,3 lastmatch=]
2
-- Print out looks right in terms of the caught groups for at least 1 ... 1 in the string (captureGroup){n,}
-- https://www.w3schools.com/java/java_regex.asp - See Quantifiers for at least 1 capture group


--- Ok finally now getting to iterating through the matches and will use the 125 value to test the multiple consecutive 1s
-- The below item now declares a new Array list of strings which we can then add to while matches.find() returns true (essentially this looks to just return the match groups as they exist in the iterable matches)
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String binaryString = Integer.toBinaryString(125);
        System.out.println(String.format("Base-10 value of : %d is equal to %s", n, binaryString));
        String consecutive1s = "((1){1,})";
        Pattern p = Pattern.compile(consecutive1s);
        Matcher matches = p.matcher(binaryString);
        System.out.println(matches);
        List<String> matchesList = new ArrayList<String>();
        while(matches.find()){
            matchesList.add(matches.group());
        }
        System.out.println(matchesList);
        bufferedReader.close();
    }
}
/*
-- Output (see we defaulted the binaryString here to get groups of at least 1 consectuvie 1) (so fro the ouptut aboe we just now need to print the length of the longest index in our matchesList)
Base-10 value of : 5 is equal to 1111101
java.util.regex.Matcher[pattern=((1){1,}) region=0,7 lastmatch=]
[11111, 1]
*/

// So this is now our solution value within the maxConsecutiveString - this is a neat way to use the Collections max items with an ArrayList and than using a Comparator.comparing(String::lenght) - as the way to get the longest string
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String binaryString = Integer.toBinaryString(125);
        System.out.println(String.format("Base-10 value of : %d is equal to %s", n, binaryString));
        String consecutive1s = "((1){1,})";
        Pattern p = Pattern.compile(consecutive1s);
        Matcher matches = p.matcher(binaryString);
        System.out.println(matches);
        List<String> matchesList = new ArrayList<String>();
        while(matches.find()){
            matchesList.add(matches.group());
        }
        System.out.println(matchesList);
        String maxConsecutiveString = Collections.max(matchesList, Comparator.comparing(String::length));
        System.out.println(maxConsecutiveString);
        bufferedReader.close();
    }
}

/*
-- Output
Base-10 value of : 5 is equal to 1111101
java.util.regex.Matcher[pattern=((1){1,}) region=0,7 lastmatch=]
[11111, 1]
11111
*/

// Submitted Solution which returns the length of the longest string of 1 for a base2 interpretation of a base10 provided int
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String binaryString = Integer.toBinaryString(n);
        String consecutive1s = "((1){1,})";
        Pattern p = Pattern.compile(consecutive1s);
        Matcher matches = p.matcher(binaryString);
        List<String> matchesList = new ArrayList<String>();
        while(matches.find()){
            matchesList.add(matches.group());
        }
        String maxConsecutiveString = Collections.max(matchesList, Comparator.comparing(String::length));
        System.out.println(maxConsecutiveString.length());
        bufferedReader.close();
    }
}