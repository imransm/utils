import org.junit.Test;

import static org.junit.Assert.*;

public class ShuffleTest {

    @Test
    public void shouldShuffleGivenInput() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        Shuffle shuffle = new Shuffle();
        for(int i=0; i<15; i++) {
            int[] result1 = shuffle.shuffle(array);
            printArray(result1);
        }

    }

    @Test
    public void shouldGenerateNumberInRange() {
        Shuffle shuffle = new Shuffle();
        int limit = 10;
        for(int i=0; i<10; i++) {
            int generatedNumber = shuffle.numberInRange(limit);
            assertTrue(generatedNumber < limit);
        }
    }

    private void printArray(int[] result) {
        for(int i : result) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

}