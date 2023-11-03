/**
 * Find the highest (hottest) temperature in a file of CSV weather data.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.io.File;
import java.lang.reflect.Field;
import java.text.Annotation;

public class CSVMax {
    public CSVRecord hottestHourInFile(CSVParser parser) {
        //start with largestSoFar as nothing
        CSVRecord largestSoFar = null;
        //For each row (currentRow) in the CSV File
        for (CSVRecord currentRow : parser) {
            //If largestSoFar is nothing
            if (largestSoFar == null) {
                largestSoFar = currentRow;
            }
            //Otherwise
            else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                //Check if currentRow’s temperature > largestSoFar’s
                if (currentTemp > largestTemp) {
                    //If so update largestSoFar to currentRow
                    largestSoFar = currentRow;
                }
            }
        }
        //The largestSoFar is the answer
        return largestSoFar;
    }
    public CSVRecord coldestHourInFile(CSVParser parser) throws IOException {
        CSVRecord coldestSoFar = null;
        for(CSVRecord curRow : parser.getRecords()){
            if (coldestSoFar == null){
                coldestSoFar = curRow;
            }
            else {
                double currentLowTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                double rowTemp = Double.parseDouble(curRow.get("TemperatureF"));
                if(rowTemp < currentLowTemp){
                    coldestSoFar = curRow;
                }
            }
        }
        return coldestSoFar;
    }
    public void testHottestInDay () {
        FileResource fr = new FileResource("data/2015/weather-2015-01-01.csv");
        CSVRecord largest = hottestHourInFile(fr.getCSVParser());
        System.out.println("hottest temperature was " + largest.get("TemperatureF") +
                   " at " + largest.get("TimeEST"));
    }
    public void testColdesHourInFile() throws NoSuchFieldException, IllegalAccessException, IOException {
        FileResource fr = new FileResource();
        Field[] frFields = fr.getClass().getDeclaredFields();
        Field passedFile = frFields[frFields.length-1];
        System.out.println(passedFile.getName());
        System.out.println(passedFile.getName().getClass());
        passedFile.setAccessible(true); // unsure of how to actually get the value (it was a private reflectField)
        CSVRecord coldestParser = coldestHourInFile(fr.getCSVParser());
        // Now we have a CSVRecord which we can call methods on for a custom output
        Double coldestTemperature = Double.parseDouble(coldestParser.get("TemperatureF"));
        //System.out.println(coldestTemperature.getClass()); // class java.lang.Double
        System.out.println(String.format("The coldest temperature from the file was : %.2f", coldestTemperature));
    }
    
}
