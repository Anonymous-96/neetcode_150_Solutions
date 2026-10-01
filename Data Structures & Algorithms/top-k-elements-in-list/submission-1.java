//Approach ==> Using Bucket Sort concept store elements in ith position having freq if
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> cntMp=new HashMap<>();
        for(int i:nums){
            cntMp.put(i,cntMp.getOrDefault(i,0)+1);
        }
        List<Integer>[] arfreq=new ArrayList[nums.length+1]; 
        for(int num: cntMp.keySet()){
            int freq=cntMp.get(num);
            if(arfreq[freq]==null){
                arfreq[freq]=new ArrayList<>();
            }
            arfreq[freq].add(num);
        }
        int[] res = new int[k];
        int idx=0;
        for(int i=arfreq.length-1;i>=0 && idx<k;i--){
            if(arfreq[i]!=null){
                for(int num:arfreq[i]){
                    res[idx++]=num;
                    if (idx == k) {
                        return res;
                    }
                }
            }
        }
        return res;
    }
}