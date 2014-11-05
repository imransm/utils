import java.util.Arrays;

/**
 * Created by Imran on 9/7/2014.
 * Find a line that passes through maximum number of points given.
 * This could be done better using a hashMap to capture line details and can run in O(N2)
 */
public class LineFitting {

    public static void main(String[] args) {
        Point[] points = new Point[]{new Point(2, 2), new Point(2, 5), new Point(4,8), new Point(9,6),
                new Point(3, 5), new Point(1, 5), new Point(2,9), new Point(5, 10), new Point(8, 16), new Point(6, 12)};

        Arrays.sort(points);
        int[] finalAnswer = fitLine(points);
        if(finalAnswer != null) {
            for(int i =0; i< points.length; i++) {
                if(finalAnswer[i] ==1) {
                    System.out.print(points[i].toString() + " ");
                }
            }
        }

    }

    private static int[] fitLine(Point[] points) {

        int finalCount = 0;
        int[] finalAnswer = null;
        for(int i = 0; i< points.length; i++) {
           for(int j = i+1; j< points.length; j++) {
               float slope = points[i].slope(points[j]);
               int[] result = tryOtherPoints(points, i, j,  slope);
               int count = countPoints(result);
               if(count > finalCount) {
                   finalCount = count;
                   finalAnswer = result;
               }
           }
        }
        return finalAnswer;
    }

    private static int countPoints(int[] result) {
        int count = 0;
        for(int i : result) {
            if(i ==1)
                count++;
        }
        return count;
    }

    private static int[] tryOtherPoints(Point[] points, int start, int end, float slope) {
        int[] included = new int[points.length];
        included[start] = 1;
        included[end] = 1;
        for(int k = end+1; k<points.length; k++) {
            float newSlope = points[end].slope(points[k]);
            if(Float.compare(slope, newSlope) == 0) {
                included[k] = 1;
            }
        }
        return included;
    }

    private static class Point implements Comparable<Point>{
        private static final float INFINITE = -9999.999f;
        private int x;
        private int y;
        public Point(int x, int y) {
            this.x =x;
            this.y =y;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }

        @Override
        public int compareTo(Point other) {
            if(other == null)
                return -1;
            if(this.x == other.x)
                return (this.y - other.y);
            else
                return this.x - other.x;
        }

        public float slope(Point p) {
            int xDiff = p.getX() - this.getX();
            if(xDiff == 0)
                return INFINITE;
            return (p.getY() - this.getY())*1.0f/ xDiff;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}
