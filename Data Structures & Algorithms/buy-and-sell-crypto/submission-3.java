class Solution {
    public int maxProfit(int[] prices) {
        int result=0;
        int min1=Integer.MAX_VALUE;

        for(int i=0;i<prices.length;i++){
            min1=Math.min(min1,prices[i]);
            result=Math.max(result,prices[i]-min1); 
        }

        return result;
    }
}
