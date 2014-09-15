import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imran on 8/24/2014.
 */
public class BinaryTree {
    protected Node root;

    public BinaryTree(){}
    public BinaryTree(int[] elements) {
        this.root = create(elements);
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node root() {
        return root;
    }
    protected Node create(int[] elements) {
        Node root = null;
        List<Node> nodeList = new ArrayList<Node>();
        nodeList.add(new Node(-999));
        for(int i=0; i< elements.length; i++) {
            nodeList.add(i+1, new Node(elements[i]));
        }
        root = nodeList.get(1);
        for(int i=1; i<= elements.length/2; i++) {
            Node n = nodeList.get(i);
            n.setLeft(nodeList.get(2*i));
            if((2*i + 1) < nodeList.size())
                n.setRight(nodeList.get(2*i +1));
        }
        nodeList.clear();
        return root;
    }

    private void inOrder(Node root) {
        if(root == null)
            return;
        inOrder(root.left());
        System.out.println(root.value());
        inOrder(root.right());
    }

    private void preOrder(Node root) {
        if(root == null)
            return;
        System.out.println(root.value());
        preOrder(root.left());
        preOrder(root.right());
    }

    private void postOrder(Node root) {
        if(root == null)
            return;
        postOrder(root.left());
        postOrder(root.right());
        System.out.println(root.value());
    }

    public void levelOrder() {
        levelOrder(root);
    }

    public List<Node> levelOrderNodeList() {
        List<Node> nodeQueue = new ArrayList<Node>();
        List<Node> visitedOrder = new ArrayList<Node>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            Node element = nodeQueue.remove(0);
            visitedOrder.add(element);
            if(element.left() != null)
                nodeQueue.add(element.left());
            if(element.right() != null) {
                nodeQueue.add(element.right());
            }
        }
        return visitedOrder;
    }

    public void inOrder() {
        inOrder(root);
    }

    public void preOrder() {
        preOrder(root);
    }

    public int size() {
        return size(root);
    }
    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if(root == null)
            return 0;
        else return 1 + Math.max(height(root.left()), height(root.right()));
    }

    private void levelOrder(Node root) {
        List<Node> nodeList = new ArrayList<Node>();
        Node dummy = new Node(-999);
        nodeList.add(root);
        nodeList.add(dummy);
        int newLinePrinted = 0;
        while(!nodeList.isEmpty()) {
            Node node = nodeList.remove(0);
            if(node == dummy) {
                System.out.println();
                if(newLinePrinted == 0)
                    nodeList.add(dummy);
                newLinePrinted++;
            } else {
                System.out.print(node.value() + " ");
                newLinePrinted=0;

                if (node.left() != null)
                    nodeList.add(node.left());
                if (node.right() != null)
                    nodeList.add(node.right());
            }
        }

    }
    private int size(Node root) {
        if(root == null)
            return 0;
        else
            return 1 + size(root.left()) + size(root.right());
    }

}
