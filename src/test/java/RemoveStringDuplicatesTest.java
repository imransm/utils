import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveStringDuplicatesTest {

    @Test
    public void shouldRemoveDuplicatesInString() {
        RemoveStringDuplicates d = new RemoveStringDuplicates();
        assertEquals("helowaryu", d.removeDupes("hellohowareyou"));
        assertEquals("poy", d.removeDupes("poppy"));
        assertEquals("p", d.removeDupes("pp"));
        assertEquals("p", d.removeDupes("p"));
        assertEquals("", d.removeDupes(""));
        assertEquals(null, d.removeDupes(null));
    }

}