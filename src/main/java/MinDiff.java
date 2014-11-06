/**
 * Created by Imran on 11/5/2014.
 * Given two sorted lists of positive numbers, find out the minimum difference between those two lists.
 */
public class MinDiff {

    int findMinDiff(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int minDiff = Integer.MAX_VALUE;
        while (i < a.length && j < b.length) {
            int diff = Math.abs(a[i] - b[j]);
            if (diff < minDiff) {
                minDiff = diff;
            }
            if(a[i] < b[j])
                i++;
            else j++;
        }
        return minDiff;
    }

    int minDiffModifiedBST(int[]a, int[] b) {
        // For each element of a, modifiedBST for such an element in b.
        int minDiff = Integer.MAX_VALUE;
        for(int i=0; i< a.length; i++) {
            int bIndex = modifiedBST(b, a[i]);
            int diff = Math.abs(a[i] - b[bIndex]);
            if(diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }

    // Modified binary modifiedBST.
    public int modifiedBST(int[] a, int goal) {
        int low = 0;
        int high = a.length -1;
        while(low < high) {
            int mid = low  + (high - low)/2;
            if(a[mid] > goal) {
                // best so far for firstKey > goal at (high)
                high = mid;
            }
            else {
                // best so far for lastKey <= goal at (low -1)
                low = mid+1;
            }
        }
        // Last key <= goal. Just less item.
        // Returning high here will be firstKey > goal.
        // If we want to return closest element here, compare low-1 and high items with goal
        return low > 0 ? low-1: low;
    }
}
