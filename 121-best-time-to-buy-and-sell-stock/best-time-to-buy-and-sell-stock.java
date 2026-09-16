class Solution {
    public int maxProfit(int[] prices) {
        int minprofit=prices[0];
        int max=0;
        for(int i=1;i<prices.length;i++){
            int profit = prices[i]-minprofit;
            max=Math.max(max,profit);
            if(minprofit>prices[i]){
                minprofit=prices[i];
            }
        }
        return max;
        
    }
}