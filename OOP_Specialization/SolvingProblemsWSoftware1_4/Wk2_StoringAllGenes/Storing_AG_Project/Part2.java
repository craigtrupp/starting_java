
/**
 * Write a description of Part2 here.
 * 
 * @author Craig
 * @version 10/30/23
 */
public class Part2 {
    public double cgRatio(String dna){
        Integer dnaLength = dna.length();
        Integer cOrG = 0;
        for (char c: dna.toCharArray()){
            if(Character.toLowerCase(c) == 'c' || Character.toLowerCase(c) == 'g'){
                cOrG++;
            }
        }
        System.out.println(String.format("The string %s had a length of : %d and a total of : %d C's or G's", 
        dna, dnaLength, cOrG));
        return (float)cOrG / dnaLength;
    }
    public void testCgRatio(){
        String testCg = "ATGCCATAG";
        cgRatio(testCg); 
        String testCgDeux = "ATggCatgeCaGG";
        System.out.println(String.format("The ratio of C's and G's was : %f", cgRatio(testCgDeux)));
        /*
        The string ATGCCATAG had a length of : 9 and a total of : 4 C's or G's
        The string ATggCatgeCaGG had a length of : 13 and a total of : 7 C's or G's
        The ratio of C's and G's was : 0.538462
        */
    }
}
