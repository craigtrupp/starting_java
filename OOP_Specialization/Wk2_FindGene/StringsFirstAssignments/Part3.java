import java.util.HashMap;
import java.util.Arrays;

/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public Boolean twoOccurrences(String stringa, String stringb){
        int occurrenceCount = 0;
        HashMap<Integer, int[]> substringStartFinishIndexes = new HashMap<Integer, int[]>();
        for(int i = 0; i < stringb.length() - stringa.length(); i++) {
            int caughtOccurrence = stringb.indexOf(stringa, i);
            if (caughtOccurrence > -1){
                occurrenceCount += 1;
                System.out.println(stringb.substring(caughtOccurrence, caughtOccurrence + stringa.length()));
                int[] indexValues = {caughtOccurrence, caughtOccurrence + stringa.length()};
                substringStartFinishIndexes.put(occurrenceCount, indexValues);
                i = caughtOccurrence + stringa.length();
                
            }
        }
        System.out.println(String.format("There were a total of %d occurence(s) for the substring", occurrenceCount));
        // Loop through Hashmap values for print out of occurences and index positions stored in array type
        substringStartFinishIndexes.forEach((k, v) -> {
            int[] theV = (int[]) v;
            System.out.println(String.format("The %d occurrence was at index positions %s: ", k, Arrays.toString(theV)));
        });
        return true;
    }
    public void test(){
        Boolean firstTest = twoOccurrences("by", "A story by Abby Long");
    }
}

/* - Print out for the First Test which looks good!
by
by
There were a total of 2 occurence(s) for the substring
The 1 occurrence was at index positions [8, 10]: 
The 2 occurrence was at index positions [13, 15]: 
*/