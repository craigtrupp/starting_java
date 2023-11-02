
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
import java.util.stream.Collectors;
import java.util.Locale;
import java.text.NumberFormat;

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
            // similar to gold or other products type string ... we need to loop through the strings as well to see if each string for export contains not just the list 
            //System.out.println(exports + "for country : " + record.get("Country"));
            Integer individualStringCheck = 0;
            for(String exportString : exports){
                if(individualStringCheck == 2){
                    exportItemCountries.add(record.get("Country"));
                    System.out.println("Country : " + record.get("Country") + " had exports of : " + exports);
                    break;
                }
                if(exportString.contains(exportItem1Cleaned) || exportString.contains(exportItem2Cleaned)){
                    individualStringCheck++;
                }
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
    public int numberOfExporters(CSVParser parser, String exportItem) throws java.io.IOException {
        String exportItemCleaned = exportItem.toUpperCase().trim();
        Integer exportCountries = 0;
        for(CSVRecord record : parser.getRecords()){
            List<String> countryExports = new ArrayList<String>(Arrays.asList(record.get("Exports").split(", ")));
            countryExports = countryExports.stream().map(String::toUpperCase).collect(Collectors.toList()); // toUpperCase makes all capital (tried and tested)
            //System.out.println(String.format("The passed country : %s had listed exports of : ", record.get("Country")) + countryExports);
            // The passed country : Germany had listed exports of : [MOTOR VEHICLES, MACHINERY, CHEMICALS] - Example print out
            // - exportdata.csv has gold generally as a singluar item but also has as : gold and other minerals (need to pluck out a different way)
            if(countryExports.contains(exportItemCleaned)){
                exportCountries++;
                continue; // initial check on country to see if gold a singular item in country's exports if so, continue to next country
            }
            // loop through exports to validate that no string contains gold ... with other characters included in country's list of string exports
            for(String exportString: countryExports){
                if(exportString.contains(exportItemCleaned)){
                    System.out.println(record.get("Country") + " " + countryExports);
                    exportCountries++;
                    break; // break out of for each loop for individual strings in export list as gold found in one of the export strings
                }
            }
        }
        return exportCountries;
    }
    public void bigExporters(CSVParser parser, String amount) throws java.io.IOException, java.text.ParseException {
        Locale locale = Locale.US;
        Number passedAmount = NumberFormat.getCurrencyInstance(locale).parse(amount);
        System.out.println(passedAmount); // Prints out value of number (numeric)
        for(CSVRecord record : parser.getRecords()){
            Number countryValue = NumberFormat.getCurrencyInstance(locale).parse(record.get("Value (dollars)"));
            if(countryValue.longValue() >= passedAmount.longValue()){
                System.out.println(String.format("%s %s", record.get("Country"), record.get("Value (dollars)")));
            }
        }
    }
    public void tester() throws java.text.ParseException, java.io.IOException {
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
        listExportersTwoProducts(twoProductsParser, "fish", "nuts");
        /*
        Namibia
        South Africa        
        */
        // Next test for numberOfExporters
        CSVParser exportItemCountries = fr.getCSVParser();
        System.out.println(String.format("The total countries with gold as a listed export was : %d", numberOfExporters(exportItemCountries, "gold")));
        // The total countries with gold as a listed export was : 3 - changed this particular method to use toUpperCase just to test the Collectors stream option
        
        // Final test for bigExporters method
        CSVParser bigExportersParser = fr.getCSVParser();
        bigExporters(bigExportersParser, "$999,999,999");
        /*
        999999999
        Germany $1,547,000,000,000
        Macedonia $3,421,000,000
        Malawi $1,332,000,000
        Malaysia $231,300,000,000
        Namibia $4,597,000,000
        Peru $36,430,000,000
        South Africa $97,900,000,000
        United States $1,610,000,000,000
        */
    }
    public void quizTester() throws java.text.ParseException, java.io.IOException{
        // master File Resource
        FileResource fr = new FileResource();
        // Question : 3 - exportdata.csv - What is the name of the country that is listed as the third country that exports both gold and diamonds
        CSVParser parserQuestionThree = fr.getCSVParser();
        listExportersTwoProducts(parserQuestionThree, "fish", "nuts");
        /* - Countries Output
        Country : Guinea-Bissau had exports of : [fish, shrimp, cashews, peanuts, palm kernels, raw and sawn lumber]
        Country : Micronesia (Federated States of) had exports of : [fish, sakau (kava), betel nuts, black pepper]
        Country : Panama had exports of : [fruit and nuts, fish, iron and steel waste, wood]
        Country : Peru had exports of : [copper, gold, lead, zinc, tin, iron ore, molybdenum, silver, crude petroleum and petroleum products, natural gas, coffee, asparagus and other vegetables, fruit, apparel and textiles, fishmeal, fish, chemicals, fabricated metal products and machinery, alloys]
        Country : Senegal had exports of : [fish, groundnuts (peanuts), petroleum products, phosphates, cotton]
        Guinea-Bissau
        Micronesia (Federated States of)
        Panama
        Peru
        Senegal
        */
        // Question : 4 - exportdata.csv - Run your program on the file exportdata.csv. How many countries export gold?
        CSVParser parserQuestionFour = fr.getCSVParser();
        System.out.println(String.format("How many countries from exportdata.csv export gold : %d", numberOfExporters(parserQuestionFour, "gold")));
        /*
        Eritrea [GOLD AND OTHER MINERALS, LIVESTOCK, SORGHUM, TEXTILES, FOOD, SMALL MANUFACTURES] - Special Case where gold is in string but not by itself
        How many countries from exportdata.csv export gold : 30
        /*
        Question : 5 - exportdata.csv - un your program on the file exportdata.csv. Call the method countryInfo with the country Nauru. 
        Which one of the following items is listed as an export from this country?
        Method returns a string so can simply print in a System.out statement
        */
        CSVParser parserQuestionFive = fr.getCSVParser();
        System.out.println(countryInfo(parserQuestionFive, "Nauru"));
        /*
        Passed country : Nauru
        Nauru: phosphates: $64,000  
        */
        /*
        Question : 6 - exportdata.csv - Question 6
        Run your program on the file exportdata.csv. What is the name of the second economy (that is, what is listed on the second line of the output) 
        listed that exports one trillion dollars or more? 
        Method has a void return type so simply need to call it
        */
        CSVParser parserQuestionSix = fr.getCSVParser();
        bigExporters(parserQuestionSix, "$1,000,000,000,000");
        /*
        -- Method Outuput
        1000000000000
        China $2,252,000,000,000
        European Union $2,173,000,000,000
        Germany $1,547,000,000,000
        United States $1,610,000,000,000
        */
    }
}
