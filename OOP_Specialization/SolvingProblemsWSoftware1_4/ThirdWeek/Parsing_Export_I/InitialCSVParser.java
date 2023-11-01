
/**
 * Write a description of InitialCSVParser here.
 * 
 * @author Craig
 * @version 11/1/23
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.util.ArrayList;
import java.util.List;


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
    public String countryInfo(CSVParser parser, String country) throws java.io.IOException {
        System.out.println(String.format("Passed country : %s", country));
        List<String> countries = new ArrayList<String>();
        List<CSVRecord> records = parser.getRecords(); // need to save records in order to iterate over multiple times (parser clears once after iterating)
        for(CSVRecord record : records){
            countries.add(record.get("Country").toLowerCase());
        }
        if(countries.contains(country.toLowerCase())){
            String country_lc = country.toLowerCase();
            for(CSVRecord record : records){
                String recordCountry = record.get("Country").toLowerCase();
                if(recordCountry.equals(country_lc)){
                    return String.format("%s: %s: %s", record.get("Country"), record.get("Exports"), record.get("Value (dollars)"));
                }
            }
            
        }
        return "NOT FOUND";
    }
    public void tester() throws java.io.IOException {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(); // default is true (so header included)
        // first all for countryInfo test (be sure to pass a new instance of parser for each method - after read the file is blank)
        System.out.println(countryInfo(parser, "Germany")); // Germany: motor vehicles, machinery, chemicals: $1,547,000,000,000
        CSVParser secondParser = fr.getCSVParser();
        System.out.println(countryInfo(secondParser, "SOUth AfRICA"));
        secondParser = fr.getCSVParser();
        System.out.println(countryInfo(secondParser, "Antartica"));
        /*
        Passed country : Germany
        Germany: motor vehicles, machinery, chemicals: $1,547,000,000,000
        Passed country : SOUth AfRICA
        South Africa: gold, diamonds, platinum: $97,900,000,000
        Passed country : Antartica
        NOT FOUND
        */
        
    }
}
