import java.util.Arrays;

/**
 * Created by moshaik on 6/2/2015.
 *
 * Given an array of n elements and a number k, randomly pick a subset of k elements.
 */
public class PickRandomSubset {

    public static void main(String[] args) {
        int[] set = {1, 2, 3, 5, 6, 7, 9, 8, 12, 25};
        int k =3;
        int l = set.length - 1;
        for(int i=0; i<k; i++) {
            int j = (int)(Math.floor(Math.random()*l));
            int temp = set[l];
            set[l] =  set[j];
            set[j] = temp;
            l = l-1;
        }
        for(int i=set.length -1; i>(set.length -1 -k); i--) {
            System.out.print(set[i] + " ");
        }
        System.out.println();
    }
}
