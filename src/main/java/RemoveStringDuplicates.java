import java.util.HashMap;
import java.util.Map;

/**
 * Created by Imran on 10/6/2014.
 * Remove duplicate characters in a given string
 */
public class RemoveStringDuplicates {

    public String removeDupes(String input) {
        if(input == null || input.length() == 0 || input.length() == 1) {
            return input;
        }
        Map<Character, Integer> found = new HashMap<Character, Integer>();
        int i=0, j=-1;
        char[] tokens = input.toCharArray();
        while(i < input.length()) {
            if(!found.containsKey(tokens[i])) {
                found.put(tokens[i], 1);
                j++;
                tokens[j] = tokens[i];
            }
            i++;
        }
        return String.valueOf(tokens, 0, j+1);
    }
}
