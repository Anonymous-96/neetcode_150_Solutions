//Approach ==> using two pointer approach, if price of l is less than r then calc profit and update maxP if it is greater then r becomes new buy day at last increase the r;  
class Solution {
    public int maxProfit(int[] prices){
        int l=0,r=1;
        int maxProfit=0;
        while(r<prices.length){
            if(prices[l]<prices[r]){
                int profit=prices[r]-prices[l];
                maxProfit=Math.max(maxProfit,profit);
            } else{
                l=r;
            }
            r++;
        }
        return maxProfit;
    }
}
