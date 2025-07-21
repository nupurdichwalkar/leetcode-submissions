class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int smallestDistance = Integer.MAX_VALUE;
        int indexResult = -1;
        for(int i=0; i<points.length; i++) {
            int currDistance = Math.abs(x-points[i][0]) + Math.abs(y-points[i][1]);
            if (currDistance < smallestDistance && (x == points[i][0] || y==points[i][1])) {
                indexResult = i;
                smallestDistance = currDistance;
            }
        }
        return indexResult;

        
    }
}
