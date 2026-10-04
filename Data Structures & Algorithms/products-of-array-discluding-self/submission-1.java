//Approiach ==> Using Prtefix and Suffic Product produt of the array except number itslef is produt of element to its right (Suffix product) and produt of its element to left (Prefix product)
class Solution {
    public int[] productExceptSelf(int[] nums) 
    {
        int n=nums.length;
        int[] res = new int[n];
        res[0]=1;
        for(int i=1;i<n;i++){
            res[i]=res[i-1]*nums[i-1];
        }
        int rightproduct=1;
        for(int i=n-1;i>=0;i--){
            res[i]*=rightproduct;
            rightproduct*=nums[i];
        }
        return res;
    }
}  
