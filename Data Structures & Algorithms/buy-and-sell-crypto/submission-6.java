class BuyandSell{
    int lower;
    int upper;
    int maxProfit;
    int[] prices;
    public BuyandSell(int[] prices){
        this.prices = prices;
        lower = 0;
        upper = 1;
        maxProfit = 0;
    }

    public int calcMaxBuyandSell(){
        while(lower < upper && upper < prices.length){
            if(badToBuy()){
                lower = upper;
                upper++;
            }
            else{
                int currProfit = 0;
                while(goodToKeep()){
                    currProfit = prices[upper] - prices[lower];
                    maxProfit = Math.max(maxProfit, currProfit);
                    upper++;
                }
                lower = upper;
                upper++;
            }
        }
        return maxProfit;
    }

    private boolean badToBuy(){
        return prices[lower] > prices[upper] ? true : false;
    }
    private boolean goodToKeep(){
        return upper < prices.length && prices[upper] >= prices[lower]? true : false;
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        BuyandSell neetCoin = new BuyandSell(prices);
        return neetCoin.calcMaxBuyandSell();
    }
}
