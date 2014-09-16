import org.junit.Test;

import static org.junit.Assert.*;

public class DuplicateRemovalTest {

    @Test
    public void shouldRemoveDuplicatesFromSortedIntArray() {
        DuplicateRemoval duplicateRemoval = new DuplicateRemoval();
        int[] input = {1, 2, 2, 2, 3, 4, 5, 5, 5, 6, 7};
        duplicateRemoval.remove(input);
        assertArrayEquals(input, new int[]{1, 2,3, 4, 5, 6, 7, 0, 0, 0, 0});
        input = new int[]{1};
        duplicateRemoval.remove(input);
        assertArrayEquals(input, new int[]{1});
        input = new int[]{1, 1, 1, 1};
        duplicateRemoval.remove(input);
        assertArrayEquals(input, new int[]{1, 0, 0, 0});
        input = new int[]{1, 2, 3, 3};
        duplicateRemoval.remove(input);
        assertArrayEquals(input, new int[]{1, 2, 3, 0});
    }

}