import org.junit.Test;

import static org.junit.Assert.*;

public class MinWindowElementsTest {

    @Test
    public void shouldPrintMinKElementsInWindowAllTheTime() {
        MinWindowElements minWindowElements = new MinWindowElements();
        minWindowElements.printMinK(new int[]{4, 5, 6, 1, 2, 3, 1, 4, 6, 7, 9, 0, 1, 10, 2, 4, 5, 6, 11}, 5, 3);
    }
}