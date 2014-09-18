/**
 * Created by moshaik on 9/16/2014.
 * Given a sorted array of integers, remove duplicates in-place
 * Seems easy, but difficult routine
 */
public class DuplicateRemoval {

    public void remove(int[] input) {
        if(input == null)
            return;
        int i=1;
        int q=0;
        while(i< input.length) {
            // We found a different element
            if(input[i] != input[i-1])
                q++;
            if(i != q  && input[i] != input[q]) {
                input[q] = input[i];
            }
            i++;
        }

        // Assign zeroes for the remaining elements
        for(int j=q+1; j< input.length; j++) {
            input[j] = 0;
        }
    }

}
