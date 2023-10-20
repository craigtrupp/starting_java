import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Difference {
  	private int[] elements;
  	public int maximumDifference;
	// Add your code here
    public Difference(int[] elements){
        this.elements = elements;
    }
    void computeDifference(){
         List<List<Integer>> arrPairs = new ArrayList<>();
        if(this.elements.length >= 2){
            for(int i = 0; i < this.elements.length - 1; i++){
                for(int j = i + 1; j < this.elements.length; j++){
                    //System.out.println(this.elements[j]);
                    List<Integer> pairsList = new ArrayList<>();
                    Collections.addAll(pairsList, this.elements[i], this.elements[j]);
                    arrPairs.add(pairsList);
                }
            }
        }
        // look at the pairs
        for(List<Integer> pair: arrPairs){
            System.out.println(pair);
        }
        for(List<Integer> pair: arrPairs){
            int pairDifference = Math.abs(pair.get(0) - pair.get(1));
            if(pairDifference > this.maximumDifference){
                this.maximumDifference = pairDifference;
            }
        }
    }

} // End of Difference class

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}

/*
-- Ok so this is predominantly for me, what we can see here is the generation of pairs and ultimately iterating over each pair to get the highest absolute difference
[1, 2]
[1, 5]
[2, 5]
4
*/

