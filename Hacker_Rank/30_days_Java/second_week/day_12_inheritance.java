/*
Task
You are given two classes, Person and Student, where Person is the base class and Student is the derived class. 
Completed code for Person and a declaration for Student are provided for you in the editor. Observe that Student inherits all the properties of Person.

Complete the Student class by writing the following:

A Student class constructor, which has 4 parameters:
    A string, firstName.
    A string, lastName.
    An integer, idNumber.
    An integer array (or vector) of test scores, scores.

A char calculate() method that calculates a Student object's average and returns the grade character representative of their calculated average:

Input Format

The locked stub code in the editor reads the input and calls the Student class constructor with the necessary arguments. It also calls the calculate method which takes no arguments.

The first line contains firstName, lastName, and idNumber, separated by a space. 
The second line contains the number of test scores. 
The third line of space-separated integers describes scores.

Output Format

Output is handled by the locked stub code (Person string representation). Your output will be correct if your Student class constructor and calculate() method are properly implemented.

Sample Input
Heraldo Memelli 8135627
2
100 80

Sample Output
Name: Memelli, Heraldo
ID: 8135627
Grade: O
*/

import java.util.*;

class Person {
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	// Constructor
	Person(String firstName, String lastName, int identification){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}
	
	// Print person data
	public void printPerson(){
		 System.out.println(
				"Name: " + lastName + ", " + firstName 
			+ 	"\nID: " + idNumber); 
	}
	 
}



class Student extends Person{
	private int[] testScores;

    /*	
    *   Class Constructor
    *   
    *   @param firstName - A string denoting the Person's first name.
    *   @param lastName - A string denoting the Person's last name.
    *   @param id - An integer denoting the Person's ID number.
    *   @param scores - An array of integers denoting the Person's test scores.
    */
    // Write your constructor here
    public Student(String firstName, String lastName, int id, int[] testScores){
            super(firstName, lastName, id);
            this.testScores = testScores;
    }
    /*	
    *   Method Name: calculate
    *   @return A character denoting the grade.
    */
    // Write your method here
    public String calculate(){
        int providedScores = 0;
        for(int score : this.testScores){
            providedScores += score;
        }
        double average = (double)providedScores / this.testScores.length;
        //System.out.print(String.format("The average was : %.2f", average));
        if (average >= 90 && average <= 100){
            return "O";
        } else if (average >= 80 && average < 90){
            return "E";
        } else if (average >= 70 && average < 80){
            return "A"; 
        } else if (average >= 55 && average < 70){
            return "P";
        } else if (average >= 40 && average < 55){
            return "D";
        } else {
            return "T";
        }
    }
}



class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for(int i = 0; i < numScores; i++){
			testScores[i] = scan.nextInt();
		}
		scan.close();
		
		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate() );
	}
}