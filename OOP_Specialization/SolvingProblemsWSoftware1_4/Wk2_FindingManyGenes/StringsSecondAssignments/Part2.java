
/**
 * Write a description of Part2 here.
 * 
 * @author (Craig) 
 * @version (10/18/23)
 */
public class Part2 {
    public Integer howMany(String stringa, String stringb){
        // Method returns an integer indicating how many times string a appears in stringb, where each occurece of string 
        // must not overlap with another occurrence of it
        // Ex : howMany("GAA", "ATGAACGAATTGAATC"); -- returns 3
        // Ex : the call howMany(“AA”, “ATAAAA”) returns 2. Note that the AA’s found cannot overlap.
        int capturedUniqueStringACount = 0;
        int lengthCondition1 = stringa.length();
        int lengthCondition2 = stringb.length();
        int idx = 0;
        while (idx < (lengthCondition2 - lengthCondition1)){
            int foundOccurence = stringb.indexOf(stringa, idx);
            if(foundOccurence == -1 && capturedUniqueStringACount < 1){
                System.out.println(String.format("There was no instance of %s within %s", stringa, stringb));
                break;
            } else if (foundOccurence == -1 && capturedUniqueStringACount >= 1){
                System.out.println(String.format("All instances found of substring"));
                break;
            }
            capturedUniqueStringACount++;
            idx = foundOccurence + lengthCondition1;
            System.out.println(String.format("Occurence : %d at string index position : %d", capturedUniqueStringACount, foundOccurence));
        }
        System.out.println(String.format("A total of %d instances of substring : %s was found for parent string : %s", capturedUniqueStringACount, stringa, stringb));
        return capturedUniqueStringACount;
    }
    public void testHowMany(){
        int firstTest = howMany("GAA", "ATGAACGAATTGAATC");
        System.out.println(String.format("firstTest returned a total of %d instances", firstTest));
        int secondTest = howMany("AA", "“ATAAAA”");
        System.out.println(String.format("secondTest returned a total of %d instances", secondTest));
        int thirdTest = howMany("GEC", "GCEADGEAC");
        System.out.println(String.format("thirdTest returned a total of %d instances", thirdTest));
    }
}
// Print Outs
/*
Occurence : 1 at string index position : 2
Occurence : 2 at string index position : 6
Occurence : 3 at string index position : 11
A total of 3 instances of substring : GAA was found for parent string : ATGAACGAATTGAATC
firstTest returned a total of 3 instances

Occurence : 1 at string index position : 3
Occurence : 2 at string index position : 5
A total of 2 instances of substring : AA was found for parent string : “ATAAAA”
secondTest returned a total of 2 instances

There was no instance of GEC within GCEADGEAC
A total of 0 instances of substring : GEC was found for parent string : GCEADGEAC
thirdTest returned a total of 0 instances
*/