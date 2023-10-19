/*
Objective
Today, we will extend what we learned yesterday about Inheritance to Abstract Classes. 
Because this is a very specific object oriented concept, submissions are limited to the few languages that use this construct. 

Task
* Given a Book class and a Solution class, write a MyBook class that does the following:
    * Inherits from Book
    * Has a parameterized constructor taking these  parameters:
        - string - title
        - string - author
        - int - price 

Implements the Book class' abstract display() method so it prints these  lines:
"Title: ", a space, and then the current instance's .
"Author: ", a space, and then the current instance's .
"Price: ", a space, and then the current instance's .

Note: Because these classes are being written in the same file, you must not use an access modifier (e.g.: ) when declaring MyBook or your code will not execute.
*/
import java.util.*;

abstract class Book {
    String title;
    String author;
    
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    abstract void display();
}

// Declare your class here. Do not use the 'public' access modifier.
class MyBook extends Book {
    // Declare the price instance variable
    private int price;
    /**   
    *   Class Constructor
    *   
    *   @param title The book's title.
    *   @param author The book's author.
    *   @param price The book's price.
    **/
    // Write your constructor here
    public MyBook(String title, String author, int price){
        super(title, author);
        this.price = price;
    }
    /**   
    *   Method Name: display
    *   
    *   Print the title, author, and price in the specified format.
    **/
    // Write your method here
    void display(){
        System.out.println(String.format("Title: %s", this.title));
        System.out.println(String.format("Author: %s", this.author));
        System.out.println(String.format("Price: %d", this.price));
    }
}  
// End class

public class Solution {
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        int price = scanner.nextInt();
        scanner.close();

        Book book = new MyBook(title, author, price);
        book.display();
    }
}

/*
- Input 
The Alchemist
Paulo Coelho
248

- Output
Title: The Alchemist
Author: Paulo Coelho
Price: 248

*/