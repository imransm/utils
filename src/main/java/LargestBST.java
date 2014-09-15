import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Imran on 9/14/2014.
 *
 * Given a binary tree, find the largest sub tree that is binary search tree.
 * Memoization included. Results are stored and not recomputed all the time.
 *
 */
public class LargestBST {

    private int memoizationCount;
    private Map<Node, Boolean> nodeMap;
    public LargestBST() {
        this.memoizationCount = 0;
        this.nodeMap = new HashMap<Node, Boolean>();
    }

    public BinarySearchTree find(BinaryTree binaryTree) {
        List<Node> levelOrderNodes = binaryTree.levelOrderNodeList();
        createMap(levelOrderNodes);
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

    private void createMap(List<Node> levelOrderNodes) {
        HashMap<Node, Boolean> nodeMap = new HashMap<Node, Boolean>();
        for(Node n: levelOrderNodes) {
            nodeMap.put(n, false);
        }
        this.nodeMap = nodeMap;
    }

    private boolean isBST(Node root) {
        if (root == null)
            return true;
        if(this.nodeMap.get(root)) {
            memoizationCount++;
            return true;
        }
       if(root.left() == null && root.right() == null) {
           this.nodeMap.put(root, true);
           return true;
       }
       if (root.left() == null) {
           boolean isBST = isBST(root.right()) && (root.value() < root.right().value());
           this.nodeMap.put(root, isBST);
           return isBST;
       }
       if(root.right() == null) {
           boolean isBST = isBST(root.left()) && (root.left().value() <= root.value());
           this.nodeMap.put(root, isBST);
           return isBST;
       }
        boolean searchTreeOrder = (root.left().value() <= root.value()) && (root.value() < root.right().value());
        boolean isBST = isBST(root.left()) && isBST(root.right()) && searchTreeOrder;
        this.nodeMap.put(root, isBST);
        return isBST;
    }

    public int getMemoizationCount() {
        return memoizationCount;
    }
}
