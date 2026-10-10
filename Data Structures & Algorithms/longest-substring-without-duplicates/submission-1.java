//Approach => using Sliding window, l is the left of window remove all the elements which has already arrived and if it doesn't contain then add it in set and increase the window size, at last update the maxLen     
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st = new HashSet<>();
        int maxLen=0;
        int len=0;
        for(int i=0;i<s.length();i++){
            while(st.contains(s.charAt(i))){
                st.remove(s.charAt(len));
                len++;
            }
            st.add(s.charAt(i));
            maxLen=Math.max(maxLen,i-len+1);
        }
        return maxLen;
    }
}
