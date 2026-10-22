//Approach ==> Sliding window with Deque DATA STRUCTURE to perform operation at both ends, any upcomimg element will be stored only if it is less and if any greater elements come pop all elements which are less than that, greatest element will always be at front side 
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n =nums.length;
        int resIndex=0;
        int[] res= new int[n-k+1];
        Deque<Integer> dq= new ArrayDeque<>();
        for(int i=0;i<n;i++){
            //remove element in front which are not in window
            if(!dq.isEmpty() && dq.peekFirst()<i-k+1){
                dq.pollFirst();
            }
            //delete the elements in rear till we they are less than upcoming element
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            //push the upcoming element now
            dq.offerLast(i);
            //start storing result when window is completed
            if(i>=k-1){
                res[resIndex++]=nums[dq.peekFirst()];
            }
        }
        return res;
    }
}