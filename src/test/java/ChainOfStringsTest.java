import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ChainOfStringsTest {

    @Test
    public void shouldCheckIfRingFormed() {
        ChainOfStrings chainOfStrings = new ChainOfStrings();
        assertTrue(chainOfStrings.isChain(new String[]{"for", "geek", "rig", "raf", "far", "kaf"}));
        assertEquals(chainOfStrings.getChain(), Arrays.asList("for", "rig", "geek", "kaf", "far", "raf"));
        assertTrue(chainOfStrings.isChain(new String[]{"aab", "bac", "aaa", "cda"}));
    }

}