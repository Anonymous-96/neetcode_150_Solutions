//Approach ===> Using Binary Search, we will first implement binary search to find the row of the target element (if exist) and then on that particular row we will again implement binary search to find out the target element. 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int l=0;
        int r=m-1;
        int row=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(target>matrix[mid][n-1]){
                l=mid+1;
            }else if(target<matrix[mid][0]){
                r=mid-1;
            }else{
                row=mid;
                break;
            }
        }
        if(row==-1) return false;
        l=0;
        r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(target>matrix[row][mid]){
                l=mid+1;
            }else if(target<matrix[row][mid]){
                r=mid-1;
            }else{
                return true;
            }
        }
        return false;
    }
}
