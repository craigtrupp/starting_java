/*
Context
Given a 6x6 2D Array, A:

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0

We define an hourglass in A to be a subset of values with indices falling in this pattern in A's graphical representation:

a b c
  d
e f g

There are 16 hourglasses in A, and an hourglass sum is the sum of an hourglass' values.

**Task**
Calculate the hourglass sum for every hourglass in , then print the maximum hourglass sum.

**Example**

In the array shown above, the maximum hourglass sum is 7 for the hourglass in the top left corner.

Input Format

There are 6 lines of input, where each line contains  space-separated integers that describe the 2D Array A.
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

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
        List<Integer> hourGlassTotals = new ArrayList<>(); 
        // first outer loop is for the rows which needs to be 2 less than the length (for the hourglass shape) indexing
        // Outer loop variables should be static for ever row as you'll be getting the same values from just another row level down
        for(int i = 0; i < arr.size() - 2; i++){
            // Set empty top_row_values of 3 which will mutate over each top row (so change in the first level loop)
            for(int j = 0; j < arr.get(i).size() - 2; j++){
                int [] top_row_values;
                top_row_values = new int[3];
                top_row_values[0] = arr.get(i).get(j);
                top_row_values[1] = arr.get(i).get(j + 1);
                top_row_values[2] = arr.get(i).get(j + 2);
                int top_row_sum = IntStream.of(top_row_values).sum();
                int middleRowValue = arr.get(i + 1).get(j + 1);
                int [] bottom_row_values;
                bottom_row_values = new int[3];
                bottom_row_values[0] = arr.get(i + 2).get(j);
                bottom_row_values[1] = arr.get(i + 2).get(j + 1);
                bottom_row_values[2] = arr.get(i + 2).get(j + 2);
                int bottom_row_sum = IntStream.of(bottom_row_values).sum();
                hourGlassTotals.add(top_row_sum + middleRowValue + bottom_row_sum);
            }
        }
        System.out.println(hourGlassTotals);
        System.out.println(Collections.max(hourGlassTotals)); // this pulls the max value for the array we were pushing values into
    }
}

// [7, 4, 2, 0, 4, 8, 10, 8, 3, 6, 7, 6, 3, 9, 19, 14] - Output (now should just need to return the highest sum from out loops and indexing of the 2d list for the different rows)


// Now just need to get the sum