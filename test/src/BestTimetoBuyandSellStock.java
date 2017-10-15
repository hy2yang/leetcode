
public class BestTimetoBuyandSellStock {
    
    public int maxProfit(int[] prices) {
        if (prices.length<2) return 0;
        int p=0;
        int min=Integer.MAX_VALUE;
        for (int i=0;i<prices.length;i++) {
            min=Math.min(prices[i], min);
            p=Math.max(p, prices[i]-min);
        }
        return (p>=0)? p:0;
    }

}
