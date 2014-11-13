import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imran on 11/12/2014.
 *
 * The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling
 * in those days. For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned
 * by buying on day 0, selling on day 3. Again buy on day 4 and sell on day 6.
 *
 * Imagine this a graph with date on X-axis and price on Y-axis. The the problem is to find increasing slopes or
 * pairs of local minima(buy) and maximas(sell).
 *
 */
public class StockProfits {

    class Pair {
        int buy;
        int sell;
        public Pair() {}

        public Pair(int buyPrice, int sellPrice) {
            this.buy = buyPrice;
            this.sell = sellPrice;
        }

        void setBuy(int buy) {
            this.buy = buy;
        }
        void setSell(int sell) {
            this.sell = sell;
        }
    }
    Pair[] computeMaxProfits(int[] prices) {

        int n = prices.length;
        List<Pair> solution = new ArrayList<Pair>();
        int i = 0;
        int solutionCount = 0;
        while(i < n) {
            // Find buy price. Usually the lowest price before prices start rising.
            // Local minima
            while(i < n -1 && prices[i+1] < prices[i]) i++;
            // Just buy, cannot be profitable. No more solutions exist.
            if(i == n -1)
                break;
            int buyPrice = prices[i];
            i++;
            // Local maxima after buy price.
            while(i < n-1 && prices[i+1] > prices[i]) i++;
            int sellPrice = prices[i];
            solution.add(new Pair(buyPrice, sellPrice));
            solutionCount++;
        }
        return solution.toArray(new Pair[0]);

    }
}
