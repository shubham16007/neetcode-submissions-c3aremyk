class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        

        HashSet<String> set= new HashSet<>(wordList);


        if(!set.contains(endWord)){
            return 0;
        }

        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        set.remove(beginWord);

        int level=0;


        while(!queue.isEmpty()){
            int size=queue.size();

            for(int i=0;i<size;i++){
            String newWord=queue.poll();

            if(newWord.equals(endWord)){
                return level+1;
            }else{

                for(String str: findNeighbor(newWord,set)){

                    if(set.contains(str)){

                        queue.offer(str);
                        set.remove(str);
                    }

                }

            }
          
            }
              level++;

        }

        return 0;
    }


    private List<String> findNeighbor(String word,HashSet<String> set){

        List<String> result=new ArrayList<>();

        for(int i=0;i<word.length();i++){

            for(char ch='a';ch<='z';ch++){

                String newString =word.substring(0,i)+ch+word.substring(i+1,word.length());

                if(set.contains(newString)){
                    result.add(newString);
                }
            }
        }

        return result;

    }
}
