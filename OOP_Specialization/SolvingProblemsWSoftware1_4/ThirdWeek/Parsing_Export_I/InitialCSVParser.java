
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
import java.util.Arrays;


public class InitialCSVParser {
    public void fileReader() throws java.io.IOException {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(true); // header included
        for(CSVRecord record : parser.getRecords()){
            // for the record's size (row elements, we can print each - just playing with the library)
            for(int i = 0; i < record.size(); i++){
                System.out.println(record.toMap());
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
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) throws java.io.IOException {
        String exportItem1Cleaned = exportItem1.toLowerCase().trim();
        String exportItem2Cleaned = exportItem2.toLowerCase().trim();
        List<String> exportItemCountries = new ArrayList<String>();
        for(CSVRecord record : parser.getRecords()){
            List<String> exports = new ArrayList<String>(Arrays.asList(record.get("Exports").split(", "))); // take string column value and split to array of strings
            if(exports.contains(exportItem1Cleaned) && exports.contains(exportItem2Cleaned)){
                exportItemCountries.add(record.get("Country"));
            }
        }
        if(exportItemCountries.size() == 0){
            System.out.println("No countries had both or either provided export item");
        }else{
            for(String country: exportItemCountries){
                System.out.println(country);
            }
        }
        
    }
    public void tester() throws java.io.IOException {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(); // default is true (so header included)
        // first all for countryInfo test (be sure to pass a new instance of parser for each method - after read the file is blank)
        System.out.println(countryInfo(parser, "Germany")); // Germany: motor vehicles, machinery, chemicals: $1,547,000,000,000
        CSVParser secondParser = fr.getCSVParser();
        System.out.println(countryInfo(secondParser, "SOUth AfRICA"));
        secondParser = fr.getCSVParser(); // can either declare a new parser or reassign for the parser to provide 
        System.out.println(countryInfo(secondParser, "Antartica"));
        /* - Passing the exports_small.csv file
        Passed country : Germany
        Germany: motor vehicles, machinery, chemicals: $1,547,000,000,000
        Passed country : SOUth AfRICA
        South Africa: gold, diamonds, platinum: $97,900,000,000
        Passed country : Antartica
        NOT FOUND
        */
        // Second test for Products
        CSVParser twoProductsParser = fr.getCSVParser();
        listExportersTwoProducts(twoProductsParser, "gold", "diamonds");
        /*
        Namibia
        South Africa        
        */
    }
}
