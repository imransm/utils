import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSumTest {
/*
  a) 3, 2, 7, 10    ans = 13 (3 + 10)
  b) 3, 2, 5, 10, 7   ans = 15 (3 + 5 + 7)
  c) 3, 2, 7, 10, 8, 25, 1  ans = 38 (3, 10, 25)
*/
    @Test
    public void shouldComputeMaxSumAsPerGivenCondition() {
        MaxSum maxSum = new MaxSum();
        assertEquals(13, maxSum.findSum(new int[] {3, 2, 7, 10}));
        assertEquals(38, maxSum.findSum(new int[] {3, 2, 7, 10, 8, 25, 1}));
        assertEquals(15, maxSum.findSum(new int[] {3, 2, 5, 10, 7}));
    }

}