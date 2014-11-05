import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PathSumTest {

    @Test
    public void shouldComputePathsThatSumUpToGivenValue() {
        int[] elements = {10, 5, 15, 2, 14, 17, 19, 3, 4, 1, 6, 20, 12, 16, 8, 9};
        BinaryTree bst = new BinaryTree(elements);
        bst.levelOrder();
        PathSum pathSum = new PathSum();
        pathSum.pathSum(bst, 21);
        List<List<Node>> allPaths = pathSum.getAllPaths();
        assertNotNull(allPaths);
        assertEquals(1, allPaths.size());
        List<Node> path = allPaths.get(0);
        assertEquals(10, path.get(0).value());
        assertEquals(5, path.get(1).value());
        assertEquals(2, path.get(2).value());
        assertEquals(4, path.get(3).value());
    }

}