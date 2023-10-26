/*
Sorting
Sorting is the act of ordering elements. The ability of a program to organize and retrieve data quickly and efficiently is incredibly important in software development. 
Learning how to effectively sort and retrieve the data you're working with enables you to write better, faster algorithms.

**Bubble Sort**
This is a very simple sorting algorithm. Because it's also very inefficient, Bubble Sort is not practical for real-world use and is generally only discussed in an academic context. 
The basic theory behind BubbleSort is that you take an array of integers and iterate through it; for each element at some index i whose value is greater than the element at the index following it 
(i.e., index i + 1 ), you must swap the two values. The act of swapping these values causes the larger, unsorted values to float to the back (like a bubble) of the data structure until they land 
in the correct location.

**Task**
Given an array, a, of size n distinct elements, sort the array in ascending order using the Bubble Sort algorithm above. Once sorted, print the following 3 lines:

1) Array is sorted in numSwaps swaps, where `numSwaps` is the number of swaps that took place.
2) First Element: firstElement, where firstElement is the first element in the sorted array.
3) Last Element: lastElement, where lastElement is the last element in the sorted array.

Hint: To complete this challenge, you will need to add a variable that keeps a running tally of all swaps that occur during execution.
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

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        // Write your code here
        int numSwaps = 0;
        int indexErrorCheck = a.size() - 1;
        int whileIterator = 0;
        while(whileIterator < indexErrorCheck){
            // 1 Condition - first index is larger than second, still want to increment counter (not extend lookback) as at beginning of array
            if(a.get(whileIterator) > a.get(whileIterator + 1) && whileIterator == 0){
                int tmp = a.get(whileIterator);
                a.set(whileIterator, a.get(whileIterator + 1));
                a.set(whileIterator + 1, tmp);
                numSwaps++;
                whileIterator++;
                continue;
            }
            // 2 Condition - Iterator >= 1 and neighboring index swap needed but index decremented to see if previous index order sorted required after neighboring sort performed
            else if(a.get(whileIterator) > a.get(whileIterator + 1) && whileIterator >= 1){
                int tmp = a.get(whileIterator);
                a.set(whileIterator, a.get(whileIterator + 1));
                a.set(whileIterator + 1, tmp);
                numSwaps++;
                whileIterator--;
                continue;
            }
            // 3 Condition - Less than or equal to, simply move the incrementer along and continue with while condition
            else {
                whileIterator++;
                continue;
            }
        }
        System.out.println(String.format("Array is sorted in %d swaps.", numSwaps));
        System.out.println(String.format("First Element: %d", a.get(0)));
        System.out.println(String.format("Last Element: %d", a.get(a.size() - 1)));
        bufferedReader.close();
    }
}
/*
- [4,3,2,8,5] -- Original Array (Loop requirements below) - while loop until iterator is less than size check - 1 (second to last index) == value in this scenario would be 4 (size() == 5 - 1)
1) i = 0; swap = [3,4,2,8,5] - (i == 0) so must increment i++
2) i = 1; swap = [3,2,4,8,5] - (i == 1) and swap occurred so we must check previous index after neighbor sort performed : i--
3) i = 0; swap = [2,3,4,8,5] - (i == 0) so must increment i++
4) i = 1; no swap = [2,3,4,8,5] - (i == 1) so else caught for iterator increase : i++
5) i = 2; no swap = [2,3,4,8,5] - (i == 2) so else caught for iterator increase : i++
6) i = 3; swap = [2,3,4,5,8] - (i == 3) second swap condition of neighbor swap needed and decrement i-- of counter to check if previous indexes (non-neighboring on current iteration) needed
7) i = 2; no swap = [2,3,4,5,8] - (i == 2) no swap needed so increment : i++
8) i = 3: no swap = [2,3,4,5,8] - (i == 3) no swap needed so increment : i++

After 8 iterations of while loop, i is now not less than indexErrorCheck of 4 and the while loop would break
    - by the start of the seventh iteration all items are sorted but the counter is 2 less than the break condition for the while loop
*/