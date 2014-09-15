import org.junit.Test;

public class LargestBSTTest {


    @Test
    public void shouldTestLargestBSTInAGivenBinaryTree() {
        int[] elements = {25, 5, 15, 2, 8, 13, 19, 1, 4, 7, 10, 12, 14, 16, 21, 0};
        BinaryTree binaryTree = new BinaryTree(elements);
        binaryTree.levelOrder();
        LargestBST largestBST = new LargestBST();
        BinarySearchTree binarySearchTree = largestBST.find(binaryTree);
        binarySearchTree.levelOrder();
    }
}