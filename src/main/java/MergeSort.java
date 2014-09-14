/**
 * Created by Imran on 9/14/2014.
 *
 * Merge sort, not space efficient.
 *
 */
public class MergeSort {

    public int[] sort(int[] elements) {
        return mergeSort(elements, 0, elements.length - 1);
    }

    private int[] mergeSort(int[] elements, int start, int end) {
        // only one element in array
        if (start == end)
            return new int[]{elements[start]};
        // two elements in the array
        else if (end - start == 1) {
            int[] sortedArray = new int[2];
            sortedArray[0] = Math.min(elements[start], elements[end]);
            sortedArray[1] = Math.max(elements[start], elements[end]);
            return sortedArray;
        }
        int mid = (start + end) / 2;
        int[] leftSortedArray = mergeSort(elements, start, mid);
        int[] rightSortedArray = mergeSort(elements, mid + 1, end);
        return merge(leftSortedArray, rightSortedArray);
    }

    public int[] merge(int[] leftSortedArray, int[] rightSortedArray) {
        if (leftSortedArray == null)
            return rightSortedArray;
        else if (rightSortedArray == null)
            return leftSortedArray;
        int p = 0;
        int q = 0;
        int r = 0;
        int combinedSize = leftSortedArray.length + rightSortedArray.length;
        int[] sortedArray = new int[combinedSize];
        while (r < combinedSize && p < leftSortedArray.length && q < rightSortedArray.length) {
            if (leftSortedArray[p] <= rightSortedArray[q]) {
                sortedArray[r] = leftSortedArray[p];
                p++;
            } else {
                sortedArray[r] = rightSortedArray[q];
                q++;
            }
            r++;
        }

        // copy back the remaining elements of left array
        while (p < leftSortedArray.length) {
            sortedArray[r] = leftSortedArray[p];
            p++;
            r++;
        }

        // copy back remaining elements of right array
        while (q < rightSortedArray.length) {
            sortedArray[r] = rightSortedArray[q];
            q++;
            r++;
        }

        return sortedArray;
    }
}
