/*
A palindrome is a word, phrase, number, or other sequence of characters which reads the same backwards and forwards. Can you determine if a given string, s, is a palindrome?

To solve this challenge, we must first take each character in s, enqueue it in a queue, and also push that same character onto a stack. 
Once that's done, we must dequeue the first character from the queue and pop the top character off the stack, then compare the two characters to see if they are the same; 
as long as the characters match, we continue dequeueing, popping, and comparing each character until our containers are empty (a non-match means s isn't a palindrome).

Stacks
A stack is a data structure that uses a principle called Last-In-First-Out (LIFO), meaning that the last object added to the stack must be the first object removed from it.

At minimum, any stack, s, should be able to perform the following three operations:

Peek: Return the object at the top of the stack (without removing it).
Push: Add an object passed as an argument to the top of the stack.
Pop: Remove the object at the top of the stack and return it.
The java.util package has a Stack class that implements these methods; check out the documentation (linked above) on the peek(), push(object), and pop() methods.

Queues
A queue is a data structure that uses a principle called First-In-First-Out (FIFO), meaning that the first object added to the queue must be the first object removed from it. You can analogize this to a checkout line at a store where the line only moves forward when the person at the head of it has been helped, and each person in the line is directly behind the person whose arrival immediately preceded theirs.

At minimum, any queue, q, should be able to perform the following two operations:

Enqueue: Add an object to the back of the line.
Dequeue: Remove the object at the head of the line and return it; the element that was previously second in line is now at the head of the line.

Write the following declarations and implementations:

Two instance variables: one for your stack, and one for your queue.
A void pushCharacter(char ch) method that pushes a character onto a stack.
A void enqueueCharacter(char ch) method that enqueues a character in the queue instance variable.
A char popCharacter() method that pops and returns the character at the top of the stack instance variable.
A char dequeueCharacter() method that dequeues and returns the first character in the queue instance variable.
*/

import java.io.*;
import java.util.*;

public class Solution {
    // Write your code here.
    Stack<Character> stack = new Stack<Character>();
    Deque<Character> queue = new LinkedList<Character>();
    
    public void pushCharacter(char ch){
        stack.push(ch);
    }
    public void enqueueCharacter(char ch){
        queue.add(ch);
    }
    public char popCharacter(){
        return stack.pop();
    }
    public char dequeueCharacter(){
        return queue.pop();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        Solution p = new Solution();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;                
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is " 
                           + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }
}