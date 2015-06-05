import java.util.Stack;

/**
 * Created by moshaik on 6/4/2015.
 *
 * Given a binary tree, print elements in zig-zag order starting from root.
 *
 * Example: For the binary tree below
 *             10
 *       5            15
 *    3     8      12    20
 *  1   4 6   9  11         25
 *
 *
 * Output:  10, 15, 5, 3, 8, 12, 20, 25, 11, 9, 6, 4, 1
 *
 *
 *
 */
public class ZigZagTreeTraversal {

    public String printZigZagTree(BinaryTree t) {
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        boolean leftToRight = true;
        s1.add(t.root);
        StringBuilder output = new StringBuilder();
        while(!(s1.empty() && s2.empty())) {
            if(leftToRight) {
                Node n = s1.pop();
                output.append(n.value() + " ");
                if(n.left() != null) s2.push(n.left());
                if(n.right() != null) s2.push(n.right());
                if(s1.empty()) {
                    leftToRight = false;
                }
            } else {
                Node n = s2.pop();
                output.append(n.value() + " ");
                if(n.right() != null) s1.push(n.right());
                if(n.left() != null) s1.push(n.left());
                if(s2.empty()) {
                    leftToRight = true;
                }
            }
        }
        return output.toString().trim();
    }
}
