import java.util.HashMap;
import java.util.Map;

/**
 * Created by Imran on 8/25/2014.
 *
 * Given a number within the range 0 - 999,999, print it in words.
 */
public class NumbersToWords {

    public static final Map<Integer, String> ONES_MAP = new HashMap<Integer, String>();
    public static final Map<Integer, String> TENS_MAP = new HashMap<Integer, String>();
    public static final Map<Integer, String> TEENS_MAP = new HashMap<Integer, String>();

    public static void main(String[] args) {
        String text = numberInWords(100156);
        System.out.println(text);
    }

    public static String numberInWords(int number) {
        init();
        int q = number/1000;
        int r = number%1000;
        if(q > 0) {
            return decodeNumber(q) + " thousand " + decodeNumber(r);
        } else {
            if(r > 0)
                return decodeNumber(r);
            else return "zero";
        }
    }

    private static void init() {
        ONES_MAP.put(1, "one");
        ONES_MAP.put(2, "two");
        ONES_MAP.put(3, "three");
        ONES_MAP.put(4, "four");
        ONES_MAP.put(5, "five");
        ONES_MAP.put(6, "six");
        ONES_MAP.put(7, "seven");
        ONES_MAP.put(8, "eight");
        ONES_MAP.put(9, "nine");

        TENS_MAP.put(2, "twenty");
        TENS_MAP.put(3, "thirty");
        TENS_MAP.put(4, "forty");
        TENS_MAP.put(5, "fifty");
        TENS_MAP.put(6, "sixty");
        TENS_MAP.put(7, "seventy");
        TENS_MAP.put(8, "eighty");
        TENS_MAP.put(9, "ninety");

        TEENS_MAP.put(10, "ten");
        TEENS_MAP.put(11, "eleven");
        TEENS_MAP.put(12, "twelve");
        TEENS_MAP.put(13, "thirteen");
        TEENS_MAP.put(14, "fourteen");
        TEENS_MAP.put(15, "fifteen");
        TEENS_MAP.put(16, "sixteen");
        TEENS_MAP.put(17, "seventeen");
        TEENS_MAP.put(18, "eighteen");
        TEENS_MAP.put(19, "nineteen");
    }

    private static String decodeNumber(int number) {
       int divisor = 100;
       String text = "";
        while(number > 0) {
            int q = number/divisor;
            int r = number %divisor;
            if(q ==1 && divisor == 10) {
                text = text + TEENS_MAP.get(number) + " ";
                break;
            }
            text = text + textString(q, divisor);
            number = r;
            divisor = divisor/10;
        }
        return text;
    }

    private static String textString(int number, int divisor) {
        if(number == 0)
            return "";
        if(divisor == 100) {
            return ONES_MAP.get(number) + " hundred ";
        } else if (divisor == 10) {
            return TENS_MAP.get(number) + " ";
        }
        else  {

            return ONES_MAP.get(number);
        }
    }


}
