import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void shouldTestBinarySearch(){
        int[] input = new int[]{1, 4, 6, 9, 10, 15, 25};
        BinarySearch binarySearch = new BinarySearch();
        assertEquals(3,binarySearch.search(input, 9, 0, 6));
        assertEquals(6,binarySearch.search(input, 25, 0, 6));
        assertEquals(-1,binarySearch.search(input, 0, 0, 6));
        assertEquals(-1, binarySearch.search(input, 26, 0, 6));
    }

}