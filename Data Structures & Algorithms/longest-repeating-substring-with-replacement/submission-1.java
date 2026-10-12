//Approach => Using sliding window, we store the frequency of each char when comes and check if current window size - freq of most frequent is less than equal to k if not then we increase the left pointer and adjust the freq of characters in that window (i.e. shrink the window) otherwise expand the window.
class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> mp = new HashMap<>();
        int l=0;
        int maxLen=0,maxF=0;
        for(int r=0;r<s.length();r++){
            mp.put(s.charAt(r),mp.getOrDefault(s.charAt(r),0)+1);
            maxF=Math.max(maxF,mp.get(s.charAt(r)));

            while((r-l+1)-maxF>k){
                mp.put(s.charAt(l),mp.get(s.charAt(l))-1);
                l++;
            }
            maxLen=Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
}
