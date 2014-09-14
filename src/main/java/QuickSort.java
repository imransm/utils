/**
 * Created by Imran on 9/13/2014.
 *
 * CLRS algorithm, selecting last element as pivot.
 *
 */
public class QuickSort {

    public void sort(int[] elements) {
        quickSort(elements, 0, elements.length - 1);
    }

    private void quickSort(int[] elements, int start, int end) {
        if(start < end) {
            int q = partition(elements, start, end);
            quickSort(elements, start, q - 1);
            quickSort(elements, q + 1, end);
        }
    }

    private int partition(int[] elements, int start, int end) {
        int pivot = elements[end];
        int i = start -1;
        for(int j = start; j<end; j++) {
            if(elements[j] <= pivot) {
                i++;
                swap(elements, i, j);
            }
        }
        swap(elements, i+1, end);
        return i+1;
    }

    private void swap(int[] elements, int i, int j) {
        int temp = elements[j];
        elements[j]=  elements[i];
        elements[i] = temp;
    }

    /**
     * Find the max element among two elements, then compare max with third element and decide the median.
     * @param i
     * @param j
     * @param k
     * @return median
     */
    public int medianOfThree(int i, int j, int k) {
        int max;
        if(i<j)
            max = j;
        else max = i;
        if (max < k)
            return max;
        else return Math.max(Math.min(i, j), k);
    }

    public static void main(String[] args) {
      QuickSort quickSort = new QuickSort();
        int[] elements = {5, 6, 7, 9, 10, 12, 1, 4, 2, 3};
        quickSort.sort(elements);
        for(int i : elements) {
            System.out.println(i);
        }
        System.out.println("Median of 3 numbers--------------------------");
        System.out.println(quickSort.medianOfThree(10, 12, 15));
        System.out.println(quickSort.medianOfThree(12, 15, 10));
        System.out.println(quickSort.medianOfThree(15, 10, 12));
    }
}
