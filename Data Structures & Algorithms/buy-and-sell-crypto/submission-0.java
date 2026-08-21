class Solution {
    public int maxProfit(int[] prices) {
        int[] maxRightVals = new int[prices.length];
        int currMaxRVal = prices[prices.length-1];
        for(int i = prices.length -1; i > -1; i--){
            currMaxRVal = Math.max(currMaxRVal, prices[i]);
            maxRightVals[i] = currMaxRVal;
            System.out.println(currMaxRVal);
        }
        currMaxRVal = 0;
        for(int i = 0; i < prices.length; i++){
            int newVal = maxRightVals[i] - prices[i];
            currMaxRVal = Math.max(currMaxRVal, newVal);
        }
        return currMaxRVal;
    }
}
