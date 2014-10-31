import java.util.Arrays;

/**
 * Created by moshaik on 9/17/2014.
 *
 * Should permute the given array as per the permutation array.
 *
 * Has bug!!
 */
public class PermuteArray {

    public void permute(int[] input, int[] permutation) {

        boolean[] processed = new boolean[input.length];
        for(int i = 0; i< permutation.length; i++) {
            if(processed[i])
                continue;
            int j = i;
            int save;
            int moveTo;
            do {
                moveTo = permutation[j];
                save = input[moveTo];
                System.out.println("Swap( " + input[j] + ", " + save);
                input[moveTo] = input[j];
                processed[moveTo] = true;
                input[j] = save;
                j = permutation[permutation[j]];
            } while(j != i);
        }
    }
}
