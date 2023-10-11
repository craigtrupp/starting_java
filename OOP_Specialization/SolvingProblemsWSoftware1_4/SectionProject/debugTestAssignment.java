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