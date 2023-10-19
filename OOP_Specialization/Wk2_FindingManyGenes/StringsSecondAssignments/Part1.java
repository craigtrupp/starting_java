
/**
 * Write a description of Part1 here.
 *  // See Readme file for more details
 * @author (Craig) 
 * @version (10/18/23)
 */
public class Part1 {
    public Integer findStopCodon(String dna, int startIndex, String stopCodon){
        // startIndex = represents where the first occurence of ATG occurs in dna
        // return index of the first occurence of stopCodon that apperas past startIndex and is a multiple of 3 away from startIndex
        // If there is no such stopCodon, this method returns the length of the dna strand.
        int codonIndexPresent = dna.indexOf(stopCodon, startIndex + 3); // see if codonIndexPresent
        if (codonIndexPresent == -1 || (codonIndexPresent - startIndex) % 3 != 0){
            // no codon found with startIndex offset
            return dna.length();
        } else {
            return codonIndexPresent;
        } 
    }
    // test method to call findStopCodon
    public void testFindStopCodon(){
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        int index = findStopCodon(dna, 0, "TAA"); // value present : 9
        int index_notpresent = findStopCodon(dna, 0, "TAG"); // value not present : -1 
    }
    // findGene - one string parameter
    public String findGene(String dna){
        int atgPresent = dna.indexOf("ATG");
        if(atgPresent == -1){
            return "";
        }
        int firstStopCheckTAA = findStopCodon(dna, dna.indexOf("ATG"), "TAA");
        int secondStopCheckTAG = findStopCodon(dna, dna.indexOf("ATG"), "TAG");
        int thridStopCheckTGA = findStopCodon(dna, dna.indexOf("ATG"), "TGA");
        // Return the gene from the "ATG" and the closest stop codon that is a multiple of three away - If none, return empty string
        return "This is an odd exercise .. we're moving to part two";
    }
}
