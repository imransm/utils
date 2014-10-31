/**
 * Created by Imran on 10/6/2014.
 */
public class ReverseString {

    public String reverseString(String input) {
        if(input == null || input.length() ==0) {
            return input;
        }
        int length = input.length();
        char[] tokens = input.toCharArray();
        for(int i=0; i< length/2; i++) {
           char temp = tokens[i];
            tokens[i] = tokens[length-1-i];
            tokens[length-1-i] = temp;
        }
        return String.valueOf(tokens);
    }

    public String recursiveReverse(String input) {
        if(input == null || input.length() ==0 || input.length() ==1) {
            return input;
        }
        return recursiveReverse(input.substring(1)) + input.charAt(0);
    }
}
