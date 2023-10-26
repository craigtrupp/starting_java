/*
Task
Write a single generic function named printArray; this function must take an array of generic elements as a parameter (the exception to this is C++, which takes a vector). 
The locked Solution class in your editor tests your function.

Note: You must use generics to solve this challenge. Do not write overloaded functions.

Input Format

The locked Solution class in your editor will pass different types of arrays to your printArray function.

Constraints

You must have exactly  function named printArray.
Output Format

Your printArray function should print each element of its generic array parameter on a new line.

note here is how in Java how to in a sense of a list of different types, have a dynamic function that can print various types of different array element types
*/

import java.util.*;

class Printer <T> {

    /**
    *    Method Name: printArray
    *    Print each element of the generic array on a new line. Do not return anything.
    *    @param A generic array
    **/
    // Write your code here
    public <E> void printArray(E[] array){
        //System.out.println(array);
        for(E element : array){
            System.out.println(element);
        }
    }
}

public class Generics {
    
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] intArray = new Integer[n];
        for (int i = 0; i < n; i++) {
            intArray[i] = scanner.nextInt();
        }

        n = scanner.nextInt();
        String[] stringArray = new String[n];
        for (int i = 0; i < n; i++) {
            stringArray[i] = scanner.next();
        }
        
        Printer<Integer> intPrinter = new Printer<Integer>();
        Printer<String> stringPrinter = new Printer<String>();
        intPrinter.printArray( intArray  );
        stringPrinter.printArray( stringArray );
        if(Printer.class.getDeclaredMethods().length > 1){
            System.out.println("The Printer class should only have 1 method named printArray.");
        }
    } 
}
/*
check out how the main items of the Generics class in a sense uses the scanner object to create an array of integers and strings for the scanning of a next int
Initially the array of integers declares a size of 3 for the first int then loops 3 times to fill the array of integers
Next, it grabs the next int after looping over the declared number of integers to create a stringArray of [n] integers
... caveat here is the input must following the basis of the integers matching matching up and the types of array to make ..  so a little hard coded
-- Input
3
1
2
3

2
Hello
World

-- Output
1
2
3
Hello
World
*/