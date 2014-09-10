import org.junit.Test;

import static org.junit.Assert.*;

public class NumbersToWordsTest {

    @Test
    public void shouldConvertGivenNumbersToWords() {
        assertEquals("nine hundred ninety nine thousand nine hundred ninety nine", NumbersToWords.numberInWords(999999));
        // fix spacing issue
        assertEquals("nine hundred  thousand ", NumbersToWords.numberInWords(900000));
        assertEquals("two hundred forty six thousand five hundred forty six", NumbersToWords.numberInWords(246546));
        assertEquals("three hundred forty six thousand five hundred forty six", NumbersToWords.numberInWords(346546));
        assertEquals("forty six thousand five hundred forty six", NumbersToWords.numberInWords(46546));
        assertEquals("six thousand five hundred forty six", NumbersToWords.numberInWords(6546));
        assertEquals("six thousand five hundred six", NumbersToWords.numberInWords(6506));
        assertEquals("five hundred forty six", NumbersToWords.numberInWords(546));
        assertEquals("forty six", NumbersToWords.numberInWords(46));
        assertEquals("six", NumbersToWords.numberInWords(6));
        assertEquals("zero", NumbersToWords.numberInWords(0));

    }

}