import org.junit.Test;

import static org.junit.Assert.*;

public class MaxArraySumTest {

  @Test
  public void maxSumArray() {

    MaxArraySum maxArraySum = new MaxArraySum();
    MaxArraySum.Pair result = maxArraySum.calculate(new int[] {904, 40, -124, 12, -335, -385, 523, 481, -31});
    System.out.println(result.toString());
  }
}