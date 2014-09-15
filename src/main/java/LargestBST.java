import java.util.List;

/**
 * Created by Imran on 9/14/2014.
 *
 * Given a binary tree, find the largest sub tree that is binary search tree.
 *
 */
public class LargestBST {

    public BinarySearchTree find(BinaryTree binaryTree) {
        List<Node> levelOrderNodes = binaryTree.levelOrderNodeList();
        int maxSize = 0;
        Node maxBSTRoot = null;
        for (Node n : levelOrderNodes) {
            if (isBST(n)) {
                int size = new BinaryTree(n).size();
                if (size > maxSize) {
                    maxSize = size;
                    maxBSTRoot = n;
                }
            }
        }
        return new BinarySearchTree(maxBSTRoot);
    }

    private boolean isBST(Node root) {
        if (root == null)
            return true;
       if(root.left() == null && root.right() == null) {
           return true;
       }
       if (root.left() == null) {
           return isBST(root.right()) && (root.value() < root.right().value());
       }
       if(root.right() == null) {
           return isBST(root.left()) && (root.left().value() <= root.value());
       }
        boolean searchTreeOrder = (root.left().value() <= root.value()) && (root.value() < root.right().value());
        return isBST(root.left()) && isBST(root.right()) && searchTreeOrder;
    }
}
