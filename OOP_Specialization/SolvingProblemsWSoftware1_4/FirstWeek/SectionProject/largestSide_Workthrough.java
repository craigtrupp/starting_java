public Point[] getLargestSide(Shape s) {
        // Put code here
        int allPoints = getNumPoints(s);
        double longestSide = 0;
        Point[] pointList = new Point[allPoints];
        for (int i = 0; i < pointList.length; i++){
            Point currPt = s.getLastPoint();
            Array.set(pointList, i, currPt);
        }
        System.out.println(Arrays.toString(pointList));
        System.out.println(s.getPoints());
        return pointList;
    }
// Print Out
// [(1,3), (1,3), (1,3), (1,3)]
// [(-1,3), (-1,-1), (4,-1), (1,3)]

// Note here how to loop through the length of all of our point and set an Array index equal to a value (however ... there is an easier way)

// getPoints() returns an iterable type which we can iterate through and add to the List on line 25 of the same object type
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