import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by moshaik on 6/5/2015.
 */
public class MaxMemoryTest {

    @Test
    public void shouldComputeMaxMemory() {
        MaxMemory maxMemory = new MaxMemory();
        LogEntry[] nextEntries = {
                new LogEntry(2, 6, 1, 100),
                new LogEntry(1, 6, 2, 300),
                new LogEntry(3, 4, 3, 100),
                new LogEntry(5, 6, 4, 300),
                new LogEntry(7, 10, 5, 350),
                new LogEntry(8, 15, 6, 150),
                new LogEntry(5, 15, 7, 150)
        };
        assertEquals(850, maxMemory.computeMaxMemory(nextEntries));
    }
}