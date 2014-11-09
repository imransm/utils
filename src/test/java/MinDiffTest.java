import org.junit.Test;
import org.testng.Assert;

public class MinDiffTest {

    @Test
    public void shouldComputeMinDifference() {
        MinDiff minDiff = new MinDiff();
        int difference = minDiff.findMinDiff(new int[]{3, 5, 9, 20, 35, 44}, new int[]{7, 14, 25, 34, 45});
        Assert.assertEquals(difference, 1);
        difference = minDiff.findMinDiff(new int[]{5, 9, 20, 35, 44}, new int[]{7, 14, 25, 36, 45});
        Assert.assertEquals(difference, 1);
    }

    @Test
    public void shouldComputeMinDifferenceUsingModifiedBinarySearch() {
        MinDiff minDiff = new MinDiff();
        int difference = minDiff.minDiffModifiedBST(new int[]{3, 5, 9, 20, 35, 44}, new int[]{7, 14, 25, 34, 45});
        Assert.assertEquals(difference, 1);
        difference = minDiff.minDiffModifiedBST(new int[]{5, 9, 20, 35, 44}, new int[]{7, 14, 25, 36, 45});
        Assert.assertEquals(difference, 1);
    }

    @Test
    public void shouldReturnIndexOfNumberJustLessThanGivenNumberUsingModifiedBST() {
        MinDiff minDiff = new MinDiff();
        Assert.assertEquals(1, minDiff.modifiedBST(new int[]{7, 14, 25, 36, 45}, 20));
    }
}