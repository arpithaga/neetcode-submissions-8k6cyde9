class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int min=prices[0];

        for(int i:prices){
            min=Math.min(i,min);
            maxProfit=Math.max(i-min,maxProfit);
        }

        return maxProfit;
    }
}
