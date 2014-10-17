import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Imran on 10/16/2014.
 *
 * Given an array of 0s and 1s. Find maximum sub array with equal number of 0s and 1s.
 * O(n) solution.
 *
 */
public class MaxSubArray {

    public int[] findSubArray(int[] input) {
        // consider 0s as -1 and compute sum.
        int[] leftSum = new int[input.length];
        int runningSum = 0;
        int maxIndex = -1;
        // Find if any sub array starting with 0 meets our requirements.
        // Look for zero in left sum.
        for(int i=0; i<input.length; i++) {
            runningSum = runningSum + (input[i] == 1 ? 1 : -1);
            leftSum[i] = runningSum;
            if(runningSum ==0) {
                if(i> maxIndex)
                    maxIndex =i;
            }
        }
        int left = 0;
        int right = maxIndex;
        int maxRange = right - left +1;
        // For sub arrays that do not start from zero, we use a map to store indices.
        // We need to find i, j in leftSum, where leftSum[i] = leftSum[j]
        Map<Integer, Integer> sumIndexMap = new HashMap<Integer, Integer>();
        for(int i=0; i<leftSum.length; i++) {
            if(!sumIndexMap.containsKey(leftSum[i])){
                sumIndexMap.put(leftSum[i], i);
            } else {
                int currentIndex = sumIndexMap.get(leftSum[i]);
                int indexDiff = i - currentIndex +1;
                if(indexDiff > maxRange) {
                    // Update lower index, because all values in between will cause the sum to remain constant.
                    left = currentIndex +1;
                    right = i;
                    maxRange = indexDiff;
                }
            }
        }
       // to - index is exclusive
       return Arrays.copyOfRange(input, left, right+1);
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] subArray = maxSubArray.findSubArray(new int[]{0,0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1});
        for(int i:subArray) {
            System.out.print(i);
        }
    }

}
