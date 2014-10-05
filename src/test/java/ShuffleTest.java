import org.junit.Test;

import static org.junit.Assert.*;

public class ShuffleTest {

    @Test
    public void shouldShuffleGivenInput() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        Shuffle shuffle = new Shuffle();
        int[] result1 = shuffle.shuffle(array);
        printArray(result1);
        result1 = shuffle.shuffle(array);
        printArray(result1);

    }

    private void printArray(int[] result) {
        for(int i : result) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

}