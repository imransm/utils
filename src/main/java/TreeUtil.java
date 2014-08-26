import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Imran on 8/24/2014.
 */
public class TreeUtil {
    public static BinaryTree createBST(int[] elements) {
        return new BinarySearchTree(elements);
    }

    public static BinaryTree createBinaryTree(int[] elements) {
        return new BinaryTree(elements);
    }
}
