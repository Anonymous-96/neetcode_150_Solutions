class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> hs1=new HashMap<>();
        HashMap<Character,Integer> hs2=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char currS=s.charAt(i);
            char currT=t.charAt(i);
            hs1.put(currS,hs1.getOrDefault(currS,0)+1);
            hs2.put(currT,hs2.getOrDefault(currT,0)+1);
        }        
         return hs1.equals(hs2);       
    }
}
