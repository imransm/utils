/**
 * Created by Imran on 9/21/2014.
 *
 * Given an array of all whose elements are positive numbers, find the maximum sum of a sub-sequence with the constraint
 * that no two numbers in the sequence should be adjacent in the array.
 * Eg:
 * a) 3, 2, 7, 10    ans = 13 (3 + 10)
 * b) 3, 2, 5, 10, 7   ans = 15 (3 + 5 + 7)
 * c) 3, 2, 7, 10, 8, 25, 1  ans = 38 (3, 10, 25)
 *
 * Dynamic programming approach - overlapping sub problems.
 *
 */
public class MaxSum {

    int findSum(int[] input) {
        int[] maxSums = new int[input.length];
        System.arraycopy(input, 0, maxSums, 0, input.length);
        for(int i=input.length-1; i>=0; i--) {
           findMaxForSubArray(input, i, maxSums);
        }
        int max = 0;
        for (int maxSum : maxSums) {
            if (maxSum > max) {
                max = maxSum;
            }
        }
        return max;
    }

    private void findMaxForSubArray(int[] input, int i, int[] maxSums) {
            int maxSumLocal = 0;
            for (int j = i + 2; j < input.length; j++) {
                findMaxForSubArray(input, j, maxSums);
                if(maxSumLocal < maxSums[j]) {
                    maxSumLocal = maxSums[j];
                }
            }
            maxSums[i] = input[i] + maxSumLocal;
    }
}
