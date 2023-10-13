
/**
 * Write a description of Part1 here.
 * 
 * @author (Craig) 
 * @version (10/12/23)
 */
public class Part1 {
    public String findSimpleGene(String dna){
        String dnaString = "";
        int dnaStartIndex = dna.indexOf("ATG");
        int dnaEndIndex = dna.indexOf("TAA", dnaStartIndex + 3);
        if (dnaStartIndex > -1 && dnaEndIndex > -1){
            // recall substring needs one length longer to include
            dnaString = dna.substring(dnaStartIndex, dnaEndIndex + 3);
            if (dnaString.length() % 3 == 0) {
                return dnaString;
            }
            return "";
            
        }
        return "";
        
    }
    public void testSimpleGene(){
        String firstTest = findSimpleGene("AATGCGBTAATATGGT");
        System.out.println(String.format("First test returned : %s", firstTest));
        String secondTest = findSimpleGene("AATGCGBTATATGGT");
        System.out.println(String.format("Second test returned : %s", secondTest));
        String thirdTest = findSimpleGene("AATGCGBETAATATGGT");
        System.out.println(String.format("Third test returned : %s", thirdTest));
    }
}
