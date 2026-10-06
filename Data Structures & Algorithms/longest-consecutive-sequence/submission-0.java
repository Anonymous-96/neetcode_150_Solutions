class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            st.add(nums[i]);
        }
        int maxCount=0;
        for(int num : st){
            if(!st.contains(num - 1)) {
                int currentNum = num;
                int count = 1;
                while(st.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}
