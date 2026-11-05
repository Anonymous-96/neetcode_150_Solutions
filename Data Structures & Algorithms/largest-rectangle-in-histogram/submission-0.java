//Approach ==> Monotonic Stack, trick is for every height we will check that how big rectangle area can be for rectangle we need height and width height will be heights[i] and width will be the left boundary i.e. that height which is lesser than slef height it will mark the boundary same as right side so we will calculate the left and right boundary of each index height and store it in two arrays and then iterate over and calculate the area and return the max area found. Note=> while doing this we will use stack to maintain the left or right boundary index at the top of stack will be the boundary.
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftBound=new int[n];
        int[] rightBound = new int[n];
        Stack<Integer> st = new Stack<>();
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            leftBound[i]=-1;
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                leftBound[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            rightBound[i]=n;
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                rightBound[i]=st.peek();
            }
            st.push(i);
        }
        for(int i=0;i<n;i++){
            leftBound[i]++;
            rightBound[i]--;
            int area=heights[i]*(rightBound[i]-leftBound[i]+1);
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
}
