//Approach ==> we use a delimiter to undestand and get to know when the urr word ends and new word starts but the delimiter may also come in word or string so for that we will first append how many harates we have to read after the delimiter so that even i delimiter omes we read it as string not the delimiter 
class Solution {
    public String encode(List<String> strs) {
        StringBuilder res=new StringBuilder();
        for(String s: strs){
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;
            //increase the j till the number ends ie we reach the symbol '#'
            while(str.charAt(j)!='#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            i=j+1;
            j=i+length;
            res.add(str.substring(i,j));
            i=j;
        }
        return res;
    }
}
