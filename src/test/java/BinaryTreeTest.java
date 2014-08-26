import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void shouldTestCreationOfBST() {
        int[] elements = {10, 5, 15, 2, 14, 17, 19, 3, 4, 1, 6, 20, 12, 16, 8, 9};
        BinaryTree bst = new BinaryTree(elements);
        assertEquals(elements.length, bst.size());
    }

    @Test
    public void shouldTestLevelOrderNodeList() {
        int[] elements = {10, 5, 15, 2, 14, 17, 19, 3, 4, 1, 6, 20, 12, 16, 8, 9};
        BinaryTree bst = new BinaryTree(elements);
        List<Node> nodes = bst.levelOrderNodeList();
        assertEquals(nodes.get(0).value(), 10);
        assertEquals(nodes.get(1).value(), 5);
        assertEquals(nodes.get(2).value(), 15);
        assertEquals(nodes.get(3).value(), 2);
        assertEquals(nodes.get(4).value(), 14);
        assertEquals(nodes.get(5).value(), 17);
        assertEquals(nodes.get(6).value(), 19);
        assertEquals(nodes.get(15).value(), 9);
        assertEquals(nodes.size(), elements.length);
    }
}