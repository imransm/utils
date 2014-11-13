import org.junit.Test;

import static org.junit.Assert.*;

public class StockProfitsTest {

    @Test
    public void shouldComputeStockProfits() {
        StockProfits stockProfits = new StockProfits();
        StockProfits.Pair[] pairs = stockProfits.computeMaxProfits(new int[]{100, 180, 260, 310, 40, 535, 365});
        for(StockProfits.Pair p : pairs) {
           System.out.println("(" + p.buy + ", " + p.sell + ")");
        }
    }

}