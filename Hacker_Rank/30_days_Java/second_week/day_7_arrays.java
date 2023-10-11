// Objective
// Today, we will learn about the Array data structure. Check out the Tutorial tab for learning materials and an instructional video.

// Task
// Given an array, A, of N integers, print A's elements in reverse order as a single line of space-separated numbers.

// Example


// Print 4 3 2 1. Each integer is separated by one space.

// Input Format

// The first line contains an integer, N (the size of our array).
// The second line contains N space-separated integers that describe array A's

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
import java.util.Arrays;


// Useful Details on how to join a integer type array, there is a stream you have to create
// then a map obj of the type to mutate and then I guess ::valueOf and finally the collectiors chain call is essentially the ' '.join() type call for the output for the string
// which has been mutated to a string type so it can be print out as a string 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        bufferedReader.close();
        int[] arr1 = new int[] {1, 2, 3, 4, 5, 6, 7};
        String result = Arrays.stream(arr1).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(arr.getClass().getName());
        System.out.println(arr1.getClass().getName());
        System.out.println(result);
        System.out.println(arr);
    }
}

// ## Input
// 4
// 1 4 3 2

// ## Output 
// java.util.ArrayList
// [I
// 1 2 3 4 5 6 7
// [1, 4, 3, 2]

// first arr is simply the ArrayList type
// Second print out is the name of the arr so an array of Integers I would suppose
// Third print out is the String result we made which is joing a list of integers into a string after mapping the object type then perform the type ' '.join call  .... much easier in other languages
// Fourth prinout above is the arr that has read in the the second line of input and use what appears a regEx expression followed by a split call to turn to an array
    // - after it maps the Integer type to the values
    // - lastly is uses a similar .collect method to change the likely map object to a list type similar to other map to list type transformations


// Check type of values in a List
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        bufferedReader.close();
        // First, change array of Integers to an array of Strings
        List<String> inputToStrings = arr.stream().map(Object::toString).collect(Collectors.toList());
        for(String str : inputToStrings){
            System.out.println(str instanceof String);
        }
        // https://stackoverflow.com/questions/12320429/java-how-to-check-the-type-of-an-arraylist-as-a-whole
        // No way to tell what type of Objects in a list other than iterate over all 
        //the contained items and check them with instanceof.
        
    }
}

// Output : instance of simply needs the variable instanceof DataType
// true
// true
// true
// true


// Now to the solution ... good lord Java is a monster 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        bufferedReader.close();
        // First, change array of Integers to an array of Strings
        List<String> inputToStrings = arr.stream().map(Object::toString).collect(Collectors.toList());
        List<String> tmp = new ArrayList<>(inputToStrings);
        Collections.reverse(tmp); // mutate list in place and then use string join method and pass java.util.ArrayList - tmp
        System.out.println(String.join(" ", tmp));
    }
}