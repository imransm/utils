import org.junit.Assert;
import org.junit.Test;

public class ReverseStringTest {

    @Test
    public void shouldTestStringReversalRecursiveRoutine() {
        ReverseString reverseString = new ReverseString();
        Assert.assertEquals("tset", reverseString.recursiveReverse("test"));
        Assert.assertEquals("olleh", reverseString.recursiveReverse("hello"));
        Assert.assertEquals("", reverseString.recursiveReverse(""));
        Assert.assertEquals(null, reverseString.recursiveReverse(null));
        Assert.assertEquals("ih", reverseString.recursiveReverse("hi"));
    }

    @Test
    public void shouldTestStringReversal() {
        ReverseString reverseString = new ReverseString();
        Assert.assertEquals("tset", reverseString.reverseString("test"));
        Assert.assertEquals("olleh", reverseString.reverseString("hello"));
        Assert.assertEquals("", reverseString.reverseString(""));
        Assert.assertEquals(null, reverseString.reverseString(null));
        Assert.assertEquals("ih", reverseString.reverseString("hi"));
    }
}