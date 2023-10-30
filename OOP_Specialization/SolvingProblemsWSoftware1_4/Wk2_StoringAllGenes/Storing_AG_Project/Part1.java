/**
 * Using the StorageResource Class
 * 
 * @author Craig Rupp
 * @version 1.0
 */

import edu.duke.*;

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
     public String findGene(String dna, int start) {
        final String START_CODON = "ATG";
        int startIndex = dna.toUpperCase().indexOf(START_CODON, start);

        if (startIndex == -1) {
            return "";
        }
        
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        
        int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
        
        if (minIndex == dna.length()) {
            return "";
        } else {
            return dna.substring(startIndex, minIndex + 3);
        }
    }
     public void testFindGene() {
        String dna = "GTTAATGTAGCTTAAACCTTTAAAGCAAGGCACTGAAAATGCCTAGATGA";
        System.out.println("Gene: " + findGene(dna, 0));
        
        dna = "GTGAGCTCACTCCATAGACACAAAGGTTTGGTCCTGGCCTTCTTATTAGT";
        System.out.println("Gene: " + findGene(dna, 0));
        
        dna = "TTTCAGTGAGCTTACACATGCAAGTATCCGCGCGCCAGTGAAAATGCCCT";
        System.out.println("Gene: " + findGene(dna, 0));
        
        dna = "TCAAATCATTACTGACCATAAAGGAGCGGGTATCAAGCACACACCTATGT";
        System.out.println("Gene: " + findGene(dna, 0));
        
        dna = "AGCTCACAACACCTTGCTTAGCCACACCCCCACGGGATACAGCAGTGATA";
        System.out.println("Gene: " + findGene(dna, 0));
    }
    
    public void printAllGenes(String dna) {
        int start = 0;
        
        while (true) {
            String gene = findGene(dna, start);
            
            if (gene.isEmpty()) {
                break;
            }
            
            System.out.println("Gene: " + gene);
            
            start = dna.indexOf(gene, start) + gene.length();
        }
    }

    public StorageResource getAllGenes(String dna){
        int start = 0;
        StorageResource genes = new StorageResource();
        while (true){
            String gene = findGene(dna, start);
            if (gene.isEmpty()){
                break;
            }
            genes.add(gene);
            start = dna.indexOf(gene, start) + gene.length();
        }
        return genes;
    }
    public void testGetAllGenes() {
        String dna = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
        StorageResource geneList = getAllGenes(dna);
        
        System.out.println("Testing getAllGenes on " + dna);
        for(String gene : geneList.data()) {
            System.out.println("Gene: " + gene);
        }
    }
}