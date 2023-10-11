import edu.duke.*;
import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int totalPoints = 0;
        for (Point thisPt : s.getPoints()) {
            totalPoints ++;
        }
        return totalPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double average = getPerimeter(s)/getNumPoints(s);
        return average;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double longestSide = 0;
        // Add items to a list of explicit point type objects with iterable returned from shape method
        List<Point> myPoints = new ArrayList<>();
        for (Point currPt : s.getPoints()) {
            myPoints.add(currPt);
        }
        int listSize = myPoints.size(); 
        for (int i = 0; i < listSize - 1; i++) {
            Point currPt = myPoints.get(i);
            Point nextPt = myPoints.get(i + 1);
            double pointDistance = currPt.distance(nextPt);
            // System.out.println(String.format("currPt x,y value of %s & nextPt x,y value of %s has a euclidean distance of %s"), 
            // currPt, nextPt, pointDistance);
            if(pointDistance > longestSide){
                longestSide = pointDistance;
            }
        }
        // This does all points except the first point and last point which closes the shape
        double lastSide = myPoints.get(0).distance(myPoints.get(myPoints.size() - 1));
        if (lastSide > longestSide) {longestSide = lastSide;}
        return longestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        return 0.0;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        return 0.0;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int points = getNumPoints(s);
        System.out.println(String.format("Total points : %d", points));
        double perimeter = getAverageLength(s);
        System.out.println(String.format("Perimeter average length : %.2f", perimeter));
        double longestSide = getLargestSide(s);
        System.out.println(String.format("The largest side from the provided shape is : %.2f", longestSide));
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
