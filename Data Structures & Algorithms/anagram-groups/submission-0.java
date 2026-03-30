class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> result=new HashMap<>();

        for(String s:strs){

        int freq[]=new int[26];

        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<26;i++){
            sb.append("#");
            sb.append(freq[i]);
        }


        String key=sb.toString();

        result.computeIfAbsent(key,k->new ArrayList<>()).add(s);

        }
        
        return new ArrayList<>(result.values());
    }
}
