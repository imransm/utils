import org.junit.Test;
import org.testng.Assert;

import static org.junit.Assert.*;

/**
 * Created by moshaik on 6/4/2015.
 */
public class ZigZagTreeTraversalTest {

    @Test
    public void shouldPrintInZigZagOrderGivenBinaryTree() {
        BinaryTree t = new BinaryTree(new int[]{10, 5, 15, 3, 8, 12, 20, 1, 4, 6, 9, 11, 25});
        ZigZagTreeTraversal z = new ZigZagTreeTraversal();
        String output = z.printZigZagTree(t);
        Assert.assertEquals(output, "10 15 5 3 8 12 20 25 11 9 6 4 1");
    }

}