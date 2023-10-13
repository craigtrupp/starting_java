
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon){
        String dnaString = "";
        for(char c : dna.toCharArray()){
            if(Character.isLowerCase(c)){
                startCodon = startCodon.toLowerCase();
                stopCodon = stopCodon.toLowerCase();
                break;
            }
        }
        int dnaStartIndex = dna.indexOf(startCodon);
        int dnaEndIndex = dna.indexOf(stopCodon, dnaStartIndex + 3);
        if (dnaStartIndex > -1 && dnaEndIndex > -1){
            dnaString = dna.substring(dnaStartIndex, dnaEndIndex + 3);
            if (dnaString.length() % 3 == 0) {
                return dnaString;
            }
            return "";
            
        }
        return "";
        
    }
    public void testSimpleGene(){
        String firstTest = findSimpleGene("AATGCGBTAATATGGT", "ATG", "TAA");
        System.out.println(String.format("First test returned : %s", firstTest));
        String secondTest = findSimpleGene("AATGCGBTATATGGT", "ATG", "TAA");
        System.out.println(String.format("Second test returned : %s", secondTest));
        String thirdTest = findSimpleGene("AATGCGBETAATATGGT", "ATG", "TAA");
        System.out.println(String.format("Third test returned : %s", thirdTest));
        String fourthTestLower = findSimpleGene("gatgctataat", "ATG", "TAA");
        System.out.println(String.format("Fourth test returned / Lower test : %s", fourthTestLower));
    }
}
