/*
Function Description
Complete the factorial function in the editor below. Be sure to use recursion.

factorial has the following paramter:
    * int n: an integer

Returns
    * int: the factorial of n
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

class Result {

    /*
     * Complete the 'factorial' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int factorial(int n) {
    // Write your code here
        if(n <= 1){
            return 1;
        }
        return n * factorial(n - 1);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.factorial(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}


/* 
-- Sample Stack
factorial(3);

-- Recursive Process
1) return 3 * factorial(2)
    - factorial(2)
        2 * factorial(1)
        - factorial(1)
            - n no hits the diminishing value and returns 1
--  so factorial(3) returns 3 * factorial(2)
-- then factorial(2) returns 2 * factorial(1)
-- then factorial(1) returns 1

-- The previous iterations are saved as all the factorial call is doing is essentially saving the diminishing value of n and the operation
-- all the factorial(n-1) is just return the value of n and the operation
 
*/