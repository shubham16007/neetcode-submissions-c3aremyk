class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> map=new HashMap<>();

        for(String str:strs){


            int freq[]=new int[26];

            for(char c:str.toCharArray()){
                freq[c-'a']++;
            }

            StringBuilder sb=new StringBuilder();

            for(int i=0;i<26;i++){
                sb.append("#");
                sb.append(freq[i]);

            }

            String key=sb.toString();

            map.computeIfAbsent(key,k->new ArrayList<>()).add(str);

        }

        return new ArrayList<>(map.values());
        
    }
}
