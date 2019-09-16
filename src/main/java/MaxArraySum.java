import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class MaxArraySum {

  @Getter
  @Setter
  @AllArgsConstructor
  @ToString
  static class Pair {
    int i;
    int j;
    int sum;
  }
  public Pair calculate(int A[]) {
    int maxSum = 0;
    int start = -1;
    int end = -1;
    int currentSum = 0;
    Pair solution = new Pair(-1, -1, 0);

    for(int i=0; i< A.length; i++) {
      currentSum += A[i];
      if(currentSum > maxSum) {

        maxSum = currentSum;
        if(start == -1) {
          start= i;
        }
        end = i;
        solution = new Pair(start, end, maxSum);
      }

      if(currentSum < 0) {

        start = -1;
        currentSum = 0;
      }
    }
    return solution;
  }
}
