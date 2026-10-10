//Approach ==> using DP Approach, for each i mark it as selling day and check for the minimum buy day on right side pf the array anf then calculate the profit and update it if it is greater than prev profit 
class Solution {
    public int maxProfit(int[] prices){
        int minBuy=prices[0];
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            int cost=prices[i]-minBuy;
            maxProfit= Math.max(maxProfit,cost);
            minBuy= Math.min(prices[i],minBuy);
        }
        return maxProfit;
    }
}
