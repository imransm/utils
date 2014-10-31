import org.junit.Test;

import static org.junit.Assert.*;

public class RepetitionsTest {

    @Test
    public void shouldCountNumberOfRepetitionsOfGivenNumberInSortedArray() {
        Repetitions repetitions = new Repetitions();
        int[] input = {1, 4, 5, 6, 7, 7, 7, 7, 7, 7, 7, 9, 10, 11, 11, 11, 15, 15, 15, 16, 16, 16};
        assertEquals(7, repetitions.countRepetitions(input, 7));
        assertEquals(1, repetitions.countRepetitions(input, 1));
        assertEquals(3, repetitions.countRepetitions(input, 11));
        assertEquals(3, repetitions.countRepetitions(input, 15));
        assertEquals(3, repetitions.countRepetitions(input, 16));
    }

}