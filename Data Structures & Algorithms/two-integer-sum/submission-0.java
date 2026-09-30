class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hmp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int b = target-nums[i];
            if(hmp.containsKey(b)){
                return new int[]{hmp.get(b),i};
            }
            hmp.put(nums[i],i);
        }
        return new int[]{};
    }
}
