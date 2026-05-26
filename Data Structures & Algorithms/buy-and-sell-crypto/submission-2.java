class Solution {
    public int maxProfit(int[] prices) {
        int result=0;
        int min1=Integer.MAX_VALUE;

        for(int i=0;i<prices.length;i++){
            int p=prices[i]-min1;
            result=Math.max(result,p);
            min1=Math.min(min1,prices[i]);
        }

        return result;
    }
}
