//Approach ==> Using HashMap and Sorting and putting eat string with their sorted oder as key which will e same for each anagram string and then retun them as list of list of string
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> hmp= new HashMap<>();
        for(String str: strs){

            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedArr = new String(charArr);

            if(!hmp.containsKey(sortedArr)){
                hmp.put(sortedArr,new ArrayList<>());
            }
            hmp.get(sortedArr).add(str);
        }
        return new ArrayList<>(hmp.values());
    }
}
