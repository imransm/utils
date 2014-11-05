/**
 * Created by moshaik on 11/4/2014.
 *
 * Given a sorted NXN matrix, rows are sorted in increasing order and columns are sorted in increasing order.
 * Write an algorithm to find an element in the matrix
 *
 * mlog(n) algorithm is possible where matrix size is mXn
 *
 */
public class SortedMatrixSearch {


    public boolean matrixSearch(int[][] matrix, int key) {
        // Assuming NXN.
        // Start from top right element.
        int i = 0;
        int j = matrix.length -1;

        do {
            if(matrix[i][j] == key) {
                System.out.println(key + " found at [" + i + ", " + j + "]");
                return true;
            } else if(key < matrix[i][j]) {
                j--;
            } else {
                i++;
            }
        } while(i<matrix.length && j >=0);
        return false;
    }
}
