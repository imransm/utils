import org.junit.Assert;
import org.junit.Test;

public class MergeIntervalsTest {

    @Test
    public void shouldMergeOverlappingIntervals() {
        MergeIntervals mergeIntervals = new MergeIntervals();
        Interval[] intervals = {new Interval(1, 3), new Interval(2, 4), new Interval(5, 7), new Interval(6, 8)};
        Interval[] mergedIntervals = mergeIntervals.mergeOverlappingIntervals(intervals);
        Assert.assertEquals(new Interval(1, 4), mergedIntervals[0]);
        Assert.assertEquals(new Interval(5, 8), mergedIntervals[1]);
    }

}