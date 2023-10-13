import edu.duke.URLResource;
/**
 * Write a description of Part4 here.
 * 
 * @author (Craig) 
 * @version (10/13/23 ... Spoooky Friday the 13th!)
 */
public class Part4 {
    public void readHTMLWebpage(String webpage, String searchString){
        URLResource webPage = new URLResource(webpage);
        for(String line : webPage.lines()){
            if(line.toLowerCase().indexOf(searchString) > -1){
                System.out.println(line);
                // so ... we're doing line searches (not words) lets just find the start of a href and the close of that html link item
                // escape to search for " start of a href link is below \" encapsulated as a string
                int linkStartIndex = line.indexOf("<a href=");
                int linkEncapsulatingOpen = line.indexOf("\"", linkStartIndex) + 1; // offset to remove " from start of link
                int linkEncapsulationClose = line.indexOf("\"", linkEncapsulatingOpen);
                String youtubeURL = line.substring(linkEncapsulatingOpen, linkEncapsulationClose);
                System.out.println(youtubeURL);
            }
        }
    }
    
    public void provideWebpage(){
        readHTMLWebpage("https://www.dukelearntoprogram.com/course2/data/manylinks.html", "youtube");
    }
}


/*
-- Output (mostly the lines just had the a href html tags .. but not all so had to do some substringing')
<a href="http://www.YouTube.com/watch?v=sdzjcBhrgp0&feature=youtu.be">
http://www.YouTube.com/watch?v=sdzjcBhrgp0&feature=youtu.be
<li> <a href="https://www.youtube.com/watch?v=pjrI91J6jOw&feature=g-u-u">
https://www.youtube.com/watch?v=pjrI91J6jOw&feature=g-u-u
<li> <a href="https://www.youtube.com/watch?v=F5RyVWI4Onk&feature=g-u-u">
https://www.youtube.com/watch?v=F5RyVWI4Onk&feature=g-u-u
<li> <a href="https://www.YouTube.com/watch?v=XwIs1nlDQ2I&feature=g-u-u">
https://www.YouTube.com/watch?v=XwIs1nlDQ2I&feature=g-u-u
<li> <a href="https://www.youtube.com/watch?v=4tsjCND2ZfM&feature=g-u-u">
https://www.youtube.com/watch?v=4tsjCND2ZfM&feature=g-u-u
<li> <a href="http://www.youtube.com/watch?v=XlOySsg7oxY">
http://www.youtube.com/watch?v=XlOySsg7oxY
<li> <a href="http://www.youtube.com/watch?v=Nej4xJe4Tdg">
http://www.youtube.com/watch?v=Nej4xJe4Tdg
<li> <a href="http://www.youtube.com/watch?v=242Z5BhJAC8">
http://www.youtube.com/watch?v=242Z5BhJAC8
<li> <a href="http://www.youtube.com/watch?v=oPRfDC8kTqM"> Women the
http://www.youtube.com/watch?v=oPRfDC8kTqM
<li> "IKEA"<a href="https://www.youtube.com/watch?feature=player_embedded&v=MOXQo7nURs0">"ExperienceThePowerOfA-bookbook"
https://www.youtube.com/watch?feature=player_embedded&v=MOXQo7nURs0
*/