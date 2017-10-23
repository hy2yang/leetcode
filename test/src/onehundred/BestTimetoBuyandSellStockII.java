package onehundred;

public class BestTimetoBuyandSellStockII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public int maxProfit(int[] prices) {
        int res=0;
        for (int i=0;i<prices.length-1;i++) {
            if (prices[i+1]>prices[i]) res+=prices[i+1]-prices[i];
        }
        return res;
    }

}
