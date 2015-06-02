/**
 * Created by moshaik on 6/1/2015.
 *
 * Given two positive integers n and k, print all increasing sequences of length k such that the elements in every sequence are from first n natural numbers.

 Examples:

 Input: k = 2, n = 3
 Output: 1 2
 1 3
 2 3

 Input: k = 5, n = 5
 Output: 1 2 3 4 5

 Input: k = 3, n = 5
 Output:
 1 2 3
 1 2 4
 1 2 5
 1 3 4
 1 3 5
 1 4 5
 2 3 4
 2 3 5
 2 4 5
 3 4 5
 */
public class GenerateSequence {

    public static void main(String[] args) {
        ps(5, 3, 0, "");
    }

    static void ps(int n, int k, int i, String result) {
        if(k==0) {
            System.out.println(result);
        } else {
            for(int j=i+1; j<=n; j++) {
                ps(n, k-1, j, result + " " + j);
            }
        }
    }
}
