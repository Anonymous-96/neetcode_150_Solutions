//Approach ==> MinHeap of size k which will be ordered by frequency and if any element comes pop the lowest frequency element apart from k elements
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> cntMp=new HashMap<>();
        for(int i:nums){
            cntMp.put(i,cntMp.getOrDefault(i,0)+1);
        }
        //MinHeap of size K based on frequency
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(cntMp.get(a), cntMp.get(b))
        );
        for(int num: cntMp.keySet()){
            minHeap.offer(num);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i]=minHeap.poll();
        }
        return res;
    }
}