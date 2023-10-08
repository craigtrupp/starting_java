import java.io.*;
import java.util.*;

public class Person {
    private int age;	
  
	public Person(int initialAge) {
  		// Add some more code to run some checks on initialAge
        if (initialAge > 0){
            age = initialAge;
        } else {
            age = 0;
            System.out.println("Age is not valid, setting age to 0.");
        }
	}

	public void amIOld() {
  		// Write code determining if this person's age is old and print the correct statement:
        String ageOutput;
        if (this.age < 13){
            ageOutput = "You are young.";
        } else if (this.age >= 13 && this.age < 18){
            ageOutput = "You are a teenager.";
        } else {
            ageOutput = "You are old.";
        }
        System.out.println(ageOutput);
	}

	public void yearPasses() {
  		// Increment this person's age.
        age += 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int age = sc.nextInt();
			Person p = new Person(age);
			p.amIOld();
			for (int j = 0; j < 3; j++) {
				p.yearPasses();
			}
			p.amIOld();
			System.out.println();
        }
		sc.close();
    }
}


// Objective
// In this challenge, we're going to learn about the difference between a class and an instance; 
// because this is an Object Oriented concept, it's only enabled in certain languages. 
// Check out the Tutorial tab for learning materials and an instructional video!

// Task
// Write a Person class with an instance variable, age, and a constructor that takes an integer, initialAge, 
// as a parameter. The constructor must assign initialAge to age after confirming the argument 
// passed as initialAge is not negative; if a negative argument is passed as initialAge, the constructor 
// should set age to 0 and print "Age is not valid, setting age to 0.". 
// In addition, you must write the following instance methods:
// * yearPasses() should increase the  instance variable by 1.
// * amIOld() should perform the following conditional actions:
//     If age < 13 , print "You are young.".
//     If age >= 13 and age < 18, print "You are a teenager."".
//     Otherwise, print "You are old."".