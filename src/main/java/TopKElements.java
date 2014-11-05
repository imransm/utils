import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by moshaik on 11/4/2014.
 *
 * Given an integer array, find top k minimum elements. k can be from 1 to size of array.
 *
 */
public class TopKElements {

    public int[] findTopKElements(int[] input, int start, int end, int k) {

       if(start < end) {
           int pos = partition(input, start, end);
           int numberOfElements = pos - start + 1;
           if (numberOfElements == k) {
               return Arrays.copyOfRange(input, start, pos + 1);
           } else if (numberOfElements > k) {
               return findTopKElements(input, start, pos - 1, k);
           } else {
               int[] collectedSoFar = Arrays.copyOfRange(input, start, pos+1);
               int[] remainingElements = findTopKElements(input, pos + 1, end, (k - (pos + 1)));
               return buildArray(collectedSoFar, remainingElements, k);
           }
       }
        return null;

    }

    private int[] buildArray(int[] collectedOutput, int[] remainingElements, int k) {
       int[] result = new int[k];
        int j = 0;
        if(collectedOutput != null)
        for(int i: collectedOutput) {
            result[j] = i;
            j++;
        }
        if(remainingElements != null)
        for(int i: remainingElements) {
            result[j] = i;
            j++;
        }
        return result;
    }

    private int partition(int[] input, int start, int end) {
       int i = start -1;
       int pivot = input[end];
       int j = start;
       while(j < end) {
           if(input[j] < pivot) {
               i++;
               // Move to lower half of array
               swap(input, i, j);
           }
           j++;
       }
       swap(input, i+1, end);
       return i+1;
    }

    private void swap(int[] input, int p1, int p2) {
        int temp = input[p1];
        input[p1] =  input[p2];
        input[p2] = temp;
    }
}
