import org.junit.Test;
import org.testng.Assert;

import static org.junit.Assert.*;

public class TopKElementsTest {

    @Test
    public void shouldReturnTopKElementsInGivenArray() {
        TopKElements topKElements = new TopKElements();
        int[] minElements = topKElements.findTopKElements(new int[]{6, 1, 3, 5, 4, 2, 7, 8, 13, 12, 10}, 0, 10, 4);
        Assert.assertEquals(1, minElements[0]);
        Assert.assertEquals(2, minElements[1]);
        Assert.assertEquals(3, minElements[2]);
        Assert.assertEquals(4, minElements[3]);
    }

}