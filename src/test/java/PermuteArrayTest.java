import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PermuteArrayTest {

    @Test
    public void shouldPermuteGivenArrayAsPerGivenPositionArray() {
        PermuteArray permuteArray = new PermuteArray();
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7};
        int[] permutation = {5, 3, 1, 2, 4, 0, 6};
        permuteArray.permute(inputArray, permutation);
        int[] expectedPermutation = new int[]{6, 3, 4, 2, 5, 1, 7};
        for(int i=0; i<inputArray.length; i++) {
            assertEquals(inputArray[i], expectedPermutation[i]);
        }
    }

}