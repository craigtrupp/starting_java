import java.util.HashMap;
import java.util.Arrays;

/**
 * Write a description of Part3 here.
 * 
 * @author (Craig) 
 * @version (10/13/23 .... oooh spooky Friday the 13th)
 */
public class Part3 {
    public Boolean twoOccurrences(String stringa, String stringb){
        System.out.println(String.format("Checking for substring : %s, within string : %s", stringa, stringb));
        int occurrenceCount = 0;
        HashMap<Integer, int[]> substringStartFinishIndexes = new HashMap<Integer, int[]>();
        for(int i = 0; i < stringb.length() - stringa.length(); i++) {
            int caughtOccurrence = stringb.indexOf(stringa, i);
            if (caughtOccurrence > -1){
                occurrenceCount += 1;
                //System.out.println(stringb.substring(caughtOccurrence, caughtOccurrence + stringa.length())); (print substring)
                int[] indexValues = {caughtOccurrence, caughtOccurrence + stringa.length()}; // adds index of start of substring, and the end value which is one greater as end index for substring is not inclusive
                substringStartFinishIndexes.put(occurrenceCount, indexValues);
                i = caughtOccurrence + stringa.length();
                
            }
        }
        System.out.println(String.format("There were a total of %d occurence(s) for the substring", occurrenceCount));
        // Loop through Hashmap values for print out of occurences and index positions stored in array type
        System.out.println(String.format("The amount of occurences/length of hash map : %d", substringStartFinishIndexes.size()));
        if(substringStartFinishIndexes.size() >= 1) {
            substringStartFinishIndexes.forEach((k, v) -> {
                int[] theV = (int[]) v;
                System.out.println(String.format("The %d occurrence was at index positions %s: ", k, Arrays.toString(theV)));
            });
            
        }
        if (occurrenceCount >= 2){
        return true;
        }
        return false;
    }
    public String lastPart(String stringa, String stringb){
        if(stringb.indexOf(stringa) > -1){
            return stringb.substring(stringb.indexOf(stringa) + stringa.length(), stringb.length());
        }
        return stringb;
    }
    
    public void test(){
        Boolean firstTest = twoOccurrences("by", "A story by Abby Long");
        System.out.println(firstTest);
        Boolean secondTest = twoOccurrences("atg", "ctgtatgta");
        System.out.println(secondTest);
        String thirdTest = lastPart("an", "banana");
        System.out.println(String.format("The lastpart check returned : %s", thirdTest));
        String fourthTest = lastPart("zoo", "forest");
        System.out.println(String.format("The lastpart check returned : %s", fourthTest));
    }
}

/* - Print out for the first parts of the quiz Test which looks good!
-- checking twoOccurences
Checking for substring : by, within string : A story by Abby Long
There were a total of 2 occurence(s) for the substring
The amount of occurences/length of hash map : 2
The 1 occurrence was at index positions [8, 10]: 
The 2 occurrence was at index positions [13, 15]: 
true
Checking for substring : atg, within string : ctgtatgta
There were a total of 1 occurence(s) for the substring
The amount of occurences/length of hash map : 1
The 1 occurrence was at index positions [4, 7]: 
false

-- checking lastPart
The lastpart check returned : ana
The lastpart check returned : forest
*/