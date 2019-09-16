import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BinarySearchTreeTest {

    @Test
    public void shouldTestCreationOfBST() {
        int[] elements = {10, 5, 15, 2, 14, 17, 19, 3, 4, 1, 6, 20, 12, 16, 8, 9};
        BinaryTree bst = new BinarySearchTree(elements);
        assertEquals(elements.length, bst.size());
        assertEquals(5, bst.height());
    }
}