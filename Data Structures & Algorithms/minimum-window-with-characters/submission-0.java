//Approach ==> Sliding Window, using left and right pointer we will store the char we want their freq in map and travese in string s and update the minWindowSize and reqCount after the reqCount equal zero that is our valid window now we will try to shrink until our reqcount remain zero else we will break the loop and increase the window size again
class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        if(t.length()>n) return "";
        HashMap<Character,Integer> mp = new HashMap<>();
        for(char ch: t.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        int reqcount=t.length();
        int l=0,r=0;
        int minWindowSize =Integer.MAX_VALUE;
        int s_idx = 0;
        while(r<n){
            char ch=s.charAt(r);
            if(mp.containsKey(ch) && mp.get(ch)>0 ) reqcount--;
            mp.put(ch,mp.getOrDefault(ch,0)-1);

            //shrink the window
            while(reqcount==0){
                int currWindowSize=r-l+1;
                if(minWindowSize > currWindowSize){
                    minWindowSize = currWindowSize;
                    s_idx = l;
                }
                char startChar = s.charAt(l);
                mp.put(startChar,mp.get(startChar)+1);
                if(mp.containsKey(startChar) && mp.get(startChar)>0){
                    reqcount++;
                }
                l++;
            }
                r++;
        }
            return minWindowSize==Integer.MAX_VALUE?"":s.substring(s_idx,s_idx+minWindowSize);
    }
}