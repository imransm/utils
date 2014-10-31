/**
 * Created by Imran on 10/25/2014.
 *
 * Generate k combinations of a given string.
 *
 */
public class Combination {

    public void printCombinations(int k, String input) {
        if(k == 0)
            return;
        if (input != null && input.length() != 0) {
            combination(k, input, "", 0);
        }
    }

    private void combination(int k, String input, String current, int next) {

        if(current.length() == k) {
            System.out.println(current);
        } else {
               for(int i=next; i<input.length(); i++) {
                   char token = input.charAt(i);
                   combination(k, input, current + token, i+1);
               }
        }
    }

    public static void main(String[] args) {
        Combination combination = new Combination();
        combination.printCombinations(2, "abcde");
    }
}
