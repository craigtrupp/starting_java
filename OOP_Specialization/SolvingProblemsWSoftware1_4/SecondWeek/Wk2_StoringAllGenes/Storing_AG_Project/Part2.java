
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
    public int countCTG(String dna, String codon){
        Integer codonCount = 0;
        if (codon.length() > dna.length()){
            return codonCount;
        }
        for (int i = 0; i < dna.length() - codon.length(); i++){
            Integer codonIndex = dna.indexOf(codon, i);
            if (codonIndex == -1){
                return codonCount;
            }
            codonCount++;
            i = codonIndex + codon.length() - 1; // natural loop progression will add 1 if consectuive codons
        }
        return codonCount;
        
    }
    public void testCountCTG(){
        String test1 = "CTGCCTGGCTGCTGKM";
        String test2 = "ctge";
        String test3 = "ct";
        String test4 = "CTGCCTGGCT";
        System.out.println(String.format("CTG count #1 : %d", countCTG(test1, "CTG")));
        System.out.println(String.format("CTG count #2 : %d", countCTG(test2, "ctg")));
        System.out.println(String.format("CTG count #3 : %d", countCTG(test3, "ctg")));
        System.out.println(String.format("CTG count #4 : %d", countCTG(test4, "CTG")));
        /*
        CTG count #1 : 4
        CTG count #2 : 1
        CTG count #3 : 0
        CTG count #4 : 2
        -- Matches on the eye test 
        */
    }

    public int countCTGWhile(String dna, String codon){
        Integer codonCount = 0;
        Integer startIndex = 0;
        while (true){
            Integer foundCodonIndex = dna.indexOf(codon, startIndex);
            if (foundCodonIndex == -1){
                return codonCount;
            }
            codonCount++;
            startIndex = foundCodonIndex + codon.length();
        }
        // at some point the foundCodonIndex will be -1 so return only needed for that condition
    }
    public void testCountCTGWhile(){
        String test1 = "ct";
        System.out.println(String.format("CTG While #1 : %d", countCTGWhile(test1, "ctg")));
        String test2 = "ctge";
        System.out.println(String.format("CTG While #2 : %d", countCTGWhile(test2, "ctg")));
        String test3 = "CTGCCTGGCTGCTGKM";
        String test4 = "CTGCCTGGCT";
        System.out.println(String.format("CTG While #3 : %d", countCTGWhile(test3, "CTG")));
        System.out.println(String.format("CTG While #4 : %d", countCTGWhile(test4, "CTG")));
        /*
        CTG While #1 : 0
        CTG While #2 : 1
        CTG While #3 : 4
        CTG While #4 : 2
        */
    }
}
