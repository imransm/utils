/**
 * Created by Imran on 10/27/2014.
 * Given a sorted array, find the number of repetitions of a given element.
 *
 */
public class Repetitions {

    public int countRepetitions(int[] input, int searchFor) {
        // Index found in binary search could be at the left corner, middle or right corner.
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.search(input, searchFor, 0, input.length-1);
        // Now search left side of the index and search for right side of the index.
        int leftIndex = index;
        int leftSoFar = index;
        while(leftIndex != -1){
            leftIndex = binarySearch.search(input, searchFor, 0, leftIndex -1);
            if(leftIndex != -1)
                leftSoFar = leftIndex;
        }

        int rightIndex = index;
        int rightSoFar = index;
        while(rightIndex != -1) {
            rightIndex = binarySearch.search(input, searchFor, rightIndex+1, input.length -1);
            if(rightIndex != -1)
                rightSoFar = rightIndex;
        }

        return (rightSoFar - leftSoFar +1);

    }
}
