class Solution {
    public int[] productExceptSelf(int[] nums) 
    {
        int n=nums.length;
        int[] res = new int[n];
        int lpdt=1,rpdt=1;
        Arrays.fill(res,1);

        for(int i=0;i<n;i++){
            res[i]*=lpdt;
            lpdt*=nums[i];

            int j=n-1-i;
            res[j]*=rpdt;
            rpdt*=nums[j];

        }
        return res;
    }
}  
