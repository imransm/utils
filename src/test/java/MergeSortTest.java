import com.sun.scenario.effect.Merge;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void shouldTestMergeSort() {
        MergeSort mergeSort = new MergeSort();
        int[] sortedArray = mergeSort.sort(new int[]{5, 1, 4, 6, 7, 9, 0});
        Assert.assertArrayEquals(new int[]{0, 1, 4, 5, 6, 7, 9}, sortedArray);
        sortedArray = mergeSort.sort(new int[]{5, 1});
        Assert.assertArrayEquals(new int[]{1, 5}, sortedArray);
        sortedArray = mergeSort.sort(new int[]{5, 1});
        Assert.assertArrayEquals(new int[]{1, 5}, sortedArray);
    }

    @Test
    public void shouldMergeTwoSortedArrays() {
        MergeSort mergeSort = new MergeSort();
        int[] mergedArray = mergeSort.merge(new int[]{5, 8, 12}, new int[]{4, 6, 14, 15});
        assertArrayEquals(new int[]{4, 5, 6, 8, 12, 14, 15}, mergedArray);
    }

}