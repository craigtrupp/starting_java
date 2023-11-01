
/**
 * Write a description of InitialCSVParser here.
 * 
 * @author Craig
 * @version 11/1/23
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class InitialCSVParser {
    public void fileReader() throws java.io.IOException {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(true); // header included
        for(CSVRecord record : parser.getRecords()){
            // for the record's size (row elements, we can print each - just playing with the library)
            System.out.println(record.toMap());
            for(int i = 0; i < record.size(); i++){
                System.out.println(record.get(i));
                /*
                 * {Country=Germany, Exports=motor vehicles, machinery, chemicals, Value (dollars)=$1,547,000,000,000}
                Germany
                motor vehicles, machinery, chemicals
                $1,547,000,000,000
                 */
            }
        }
    }
    
}
