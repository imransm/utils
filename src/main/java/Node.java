/**
 * Created by Imran on 8/24/2014.
 */
public class Node {
    private final int value;
    private  Node left;
    private  Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int value() {
       return value;
    }

    public Node left() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node right() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
