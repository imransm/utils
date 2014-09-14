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
        for (Node n : bst.levelOrderNodeList()) {
            ArrayList<Node> path = new ArrayList<Node>();
            path.add(n);
            findSum(n, sum, n.value(), path);
        }
    }

    private static void findSum(Node root, int sum, int currentSum, ArrayList<Node> path) {
        if (root == null)
            return;
        if (sum == currentSum) {
            printPath(path);
        }

        if (root.left() != null && currentSum + root.left().value() <= sum) {
            ArrayList<Node> rootLeftPath = new ArrayList<Node>(path);
            rootLeftPath.add(root.left());
            findSum(root.left(), sum, currentSum + root.left().value(), rootLeftPath);
        }

        if (root.right() != null && currentSum + root.right().value() <= sum) {
            ArrayList<Node> rootRightPath = new ArrayList<Node>(path);
            rootRightPath.add(root.right());
            findSum(root.right(), sum, currentSum + root.right().value(), rootRightPath);
        }
    }

    private static void printPath(ArrayList<Node> path) {
        for (Node n : path) {
            System.out.print(n.value() + " ");
        }
        System.out.println();
    }
}