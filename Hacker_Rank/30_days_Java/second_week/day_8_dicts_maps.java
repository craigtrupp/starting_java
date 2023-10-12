/*
Objective
Today, we're learning about Key-Value pair mappings using a Map or Dictionary data structure.

Task
Given n names and phone numbers, assemble a phone book that maps friends' names to their respective phone numbers. You will then be given an
unknown number of names to query your phone book for. For each name queried, print the associated entry from your phone book on a new line in the form name=phoneNumber; 
if an entry for name is not found, print Not found instead.

Note: Your phone book should be a Dictionary/Map/HashMap data structure.


Input Format

The first line contains an integer, n, denoting the number of entries in the phone book.
Each of the n subsequent lines describes an entry in the form of 2 space-separated values on a single line. 
The first value is a friend's name, and the second value is an 8-digit phone number.

After the n lines of phone book entries, there are an unknown number of lines of queries. 
Each line (query) contains a name to look up, and you must continue reading lines until there is no more input.

Note: Names consist of lowercase English alphabetic letters and are first names only

Output Format

On a new line for each query, print "Not found" if the name has no corresponding entry in the phone book; otherwise, print the 
full name and phoneNumber in the format name=phoneNumber.

Sample Input
3
sam 99912222
tom 11122222
harry 12299933
sam
edward
harry

Sample Output
sam=99912222
Not found
harry=12299933
*/

// Some Java Type mutation first
class Solution{
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        String firstLine = in.nextLine();
        Integer firstLineInt = Integer.valueOf(firstLine);
        System.out.println(String.format("Pre mutation type : %s. Post mutation type : %s", firstLine.getClass(), firstLineInt.getClass()));
    }
}
// Pre mutation type : class java.lang.String. Post mutation type : class java.lang.Integer

// Alright let's get cracking 
class Solution{
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int phoneEntries = in.nextInt();
        Map<String, Integer> phoneBook = new HashMap<String, Integer>();
        for (int i = 0;  i < phoneEntries; i++){
            String name = in.next();
            int number = in.nextInt();
            phoneBook.put(name, number);
        }
        in.close();
        for (Map.Entry<String, Integer> pn : phoneBook.entrySet()){
            System.out.println(pn.getKey());
            System.out.println(pn.getValue());
        }
    }
}
// tom
// 11122222
// harry
// 12299933
// sam
// 99912222

// Answer with my output 
//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int phoneEntries = in.nextInt();
        Map<String, Integer> phoneBook = new HashMap<String, Integer>();
        for (int i = 0;  i < phoneEntries; i++){
            String name = in.next();
            int number = in.nextInt();
            phoneBook.put(name, number);
        }
        while (in.hasNext()){
            String nameCheck = in.next();
            if(phoneBook.containsKey(nameCheck)){
                int phoneNumber = phoneBook.get(nameCheck);
                System.out.println(String.format("%s=%d", nameCheck, phoneNumber));
            } else {
                System.out.println(String.format("%s not found! Lo Siento", nameCheck));
            }
        }
        in.close();
    }
}
/*
See input above as same for test

**Output**
sam=99912222
edward not found! Lo Siento
harry=12299933
*/


