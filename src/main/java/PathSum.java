import java.util.ArrayList;

/**
 * Created by Imran on 8/24/2014.
 *
 * Given a binary tree with node values and a number. Find all paths that sum up to the given number.
 *
 */
public class PathSum {

    public static void main(String[] args) {
        int[] elements = {10, 5, 15, 2, 14, 17, 19, 3, 4, 1, 6, 20, 12, 16, 8, 9};
        BinaryTree bst = new BinaryTree(elements);
        bst.levelOrder();
        pathSum(bst, 21);

    }

    private static void pathSum(BinaryTree bst, int sum) {
        /*
          Paths can start from any node. So, we consider all paths that start from a particular node.
         */
        for (Node n : bst.levelOrderNodeList()) {
            ArrayList<Node> path = new ArrayList<Node>();
            path.add(n);
            findSum(n, sum, n.value(), path);
        }
    }

    private static void findSum(Node startNode, int sum, int currentSum, ArrayList<Node> path) {
        if (startNode == null)
            return;
        if (sum == currentSum) {
            printPath(path);
        }

        if (startNode.left() != null && currentSum + startNode.left().value() <= sum) {
            ArrayList<Node> rootLeftPath = new ArrayList<Node>(path);
            rootLeftPath.add(startNode.left());
            findSum(startNode.left(), sum, currentSum + startNode.left().value(), rootLeftPath);
        }

        if (startNode.right() != null && currentSum + startNode.right().value() <= sum) {
            ArrayList<Node> rootRightPath = new ArrayList<Node>(path);
            rootRightPath.add(startNode.right());
            findSum(startNode.right(), sum, currentSum + startNode.right().value(), rootRightPath);
        }
    }

    private static void printPath(ArrayList<Node> path) {
        for (Node n : path) {
            System.out.print(n.value() + " ");
        }
        System.out.println();
    }
}
