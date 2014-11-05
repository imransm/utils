import org.junit.Test;

import static org.junit.Assert.*;

public class LCSTest {

    @Test
    public void shouldComputeLCS() {
        LCS lcs = new LCS();
        assertEquals("oato", lcs.findLCS("tomato", "potato"));
        assertEquals("ATGTG", lcs.findLCS("ATGTG", "AGTTGTGA"));
    }


}