import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imran on 8/24/2014.
 *
 * Given a binary tree with node values and a number. Find all paths that sum up to the given number.
 *
 */
public class PathSum {

    private List<List<Node>> allPaths;
    public PathSum() {
        allPaths = new ArrayList<List<Node>>();
    }
    public void pathSum(BinaryTree bst, int sum) {
        /*
          Paths can start from any node. So, we consider all paths that start from a particular node.
         */
        for (Node n : bst.levelOrderNodeList()) {
            ArrayList<Node> path = new ArrayList<Node>();
            path.add(n);
            findSum(n, sum, n.value(), path);
        }
    }

    private void findSum(Node startNode, int sum, int currentSum, ArrayList<Node> path) {
        if (startNode == null)
            return;
        if (sum == currentSum) {
            printPath(path);
        }

        if (startNode.left() != null) {
            ArrayList<Node> rootLeftPath = new ArrayList<Node>(path);
            rootLeftPath.add(startNode.left());
            findSum(startNode.left(), sum, currentSum + startNode.left().value(), rootLeftPath);
        }

        if (startNode.right() != null) {
            ArrayList<Node> rootRightPath = new ArrayList<Node>(path);
            rootRightPath.add(startNode.right());
            findSum(startNode.right(), sum, currentSum + startNode.right().value(), rootRightPath);
        }
    }

    private void printPath(List<Node> path) {
        for (Node n : path) {
            System.out.print(n.value() + " ");
        }
        System.out.println();
        allPaths.add(path);
    }

    public List<List<Node>> getAllPaths() {
        return allPaths;
    }
}
