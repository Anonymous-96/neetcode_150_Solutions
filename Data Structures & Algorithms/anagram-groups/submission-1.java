class Solution {
    //Using frequency array to optimise the sorting overhead
    String generate(String word){
        int[] count = new int[26];
        for(char ch : word.toCharArray()){
            count[ch-'a']++;
        }
        StringBuilder new_String= new StringBuilder();
        for(int i=0;i<26;i++){
            if(count[i]>0){
                new_String.append(String.valueOf((char) (i + 'a')).repeat(count[i]));
            }
        }
        return new_String.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hmp= new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String word = strs[i];
            String new_word = generate(word);
            if(!hmp.containsKey(new_word)){
                hmp.put(new_word,new ArrayList<>());
            }
            hmp.get(new_word).add(word);
        }
        return new ArrayList<>(hmp.values());
    }
}