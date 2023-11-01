/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
*/
import edu.duke.*;
import java.lang.Math;

public class Part3 {
    public void processGenes(StorageResource sr){
        Integer stringGtNine = 0;
        Integer stingCGRationGt35 = 0;
        for (String strStr: sr.data()){
            if (strStr.length() > 9){
                stringGtNine++;
                System.out.println(String.format("String greater than 9 : %s", strStr));
            }
            if (cgRatio(strStr) > 0.35){
                double cgRatioValue = cgRatio(strStr);
                System.out.println(cgRatioValue);
                stingCGRationGt35++;
                System.out.println(String.format("String : %s had a ratio of CG gt .35 : %,.2f", 
                strStr, cgRatioValue));
            }
        }
        System.out.println(String.format("Total numbers of strings in received Storage Resource : %d",
        sr.size()));
        System.out.println(String.format("Total number of strings with length greater than 9 in Resource = %d", 
        stringGtNine));
        System.out.println(String.format("Total number of strings with CG ratio greater than .35 = %d", 
        stingCGRationGt35));
    }
    public double cgRatio(String dna){
        Integer dnaLength = dna.length();
        Integer cOrG = 0;
        for (char c: dna.toCharArray()){
            if(Character.toLowerCase(c) == 'c' || Character.toLowerCase(c) == 'g'){
                cOrG++;
            }
        }
        return (float)cOrG / dnaLength;
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
    public void testProcessGenes(){
        StorageResource firstSR = new StorageResource();
        firstSR.add("CGSTRECGSTCGCG");
        firstSR.add("CGSTECGL");
        firstSR.add("CGTLDERS");
        firstSR.add("CGSTELADGAECGARAL");
        processGenes(firstSR);
    }
}
/*
String greater than 9 : CGSTRECGSTCGCG
0.5714285969734192
String : CGSTRECGSTCGCG had a ratio of CG gt .35 : 0.57
0.5
String : CGSTECGL had a ratio of CG gt .35 : 0.50
String greater than 9 : CGSTELADGAECGARAL
Total numbers of strings in received Storage Resource : 4
Total number of strings with length greater than 9 in Resource = 2
Total number of strings with CG ratio greater than .35 = 2
*/
