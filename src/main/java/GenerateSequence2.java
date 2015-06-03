/**
 * Created by moshaik on 6/2/2015.
 *
 * Given a set of characters and a positive integer k, print all possible strings of length k that can be formed from the given set.

 Examples:

 Input:
 set[] = {'a', 'b'}, k = 3

 Output:
 aaa
 aab
 aba
 abb
 baa
 bab
 bba
 bbb


 Input:
 set[] = {'a', 'b', 'c', 'd'}, k = 1
 Output:
 a
 b
 c
 d
 *
 */
public class GenerateSequence2 {

    public static void main(String[] args) {
        gs(new char[]{'a', 'b'}, 3, "");
        gs(new char[]{'a', 'b', 'c', 'd'}, 1, "");
    }

    static void gs(char[] input, int k, String result) {
        if(k==0)
        {
            System.out.println(result);
        } else {
            for(int i=0; i<input.length; i++) {
                gs(input, k-1, result + input[i]);
            }
        }
    }
}
