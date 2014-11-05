import org.junit.Test;

import static org.junit.Assert.*;

public class SortedMatrixSearchTest {

    @Test
    public void shouldSearchForElementInGivenSortedMatrix() {
        SortedMatrixSearch sortedMatrixSearch = new SortedMatrixSearch();
        int[][] matrix = new int[][]{{1,5,10},{2,7,11},{5,9,15}};
        assertTrue(sortedMatrixSearch.matrixSearch(matrix, 9));
        assertTrue(sortedMatrixSearch.matrixSearch(matrix, 1));
        assertTrue(sortedMatrixSearch.matrixSearch(matrix, 2));
        assertTrue(sortedMatrixSearch.matrixSearch(matrix, 11));
        assertTrue(sortedMatrixSearch.matrixSearch(matrix, 15));
        assertFalse(sortedMatrixSearch.matrixSearch(matrix, 16));
    }

}