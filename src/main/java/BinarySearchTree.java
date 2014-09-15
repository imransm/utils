/**
 * Created by Imran on 8/24/2014.
 */
public class BinarySearchTree extends BinaryTree {

    public BinarySearchTree(int[] elements) {
        this.root = create(elements);
    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public Node create(int[] elements) {
        Node root = null;
        for(int i: elements) {

            Node n = new Node(i);
            if(root == null) {
                root = n;
            }
            else {
                addNodeToTree(root, n);
            }

        }
        return root;
    }

    private void addNodeToTree(Node root, Node n) {

        if(n.value() < root.value() ) {
            if(root.left() == null) {
                root.setLeft(n);
            } else {
                addNodeToTree(root.left(), n);
            }
        }
        else {
            if(root.right() == null) {
                root.setRight(n);
            } else {
                addNodeToTree(root.right(), n);
            }
        }

    }

}
