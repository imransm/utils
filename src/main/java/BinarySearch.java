/**
 * Created by Imran on 10/27/2014.
 */
public class BinarySearch {

    public int search(int[] input, int searchFor) {
        int index = -1;
        int left = 0;
        int right = input.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (input[mid] == searchFor) {
                index = mid;
                break;
            } else if (searchFor < input[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;

    }
}
