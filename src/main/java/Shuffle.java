/**
 * Created by Imran on 10/4/2014.
 * Knuth's shuffle algorithm.
 *
 */
public class Shuffle {

    public int[] shuffle(int[] input) {
        for(int i=input.length -1; i> 0; i--) {
            int j = Math.round((float)Math.floor(Math.random()*i));
            int temp = input[j];
            input[j] = input[i];
            input[i] = temp;
        }
        return input;
    }
}
