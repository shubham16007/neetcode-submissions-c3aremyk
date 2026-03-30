class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set=new HashSet<>(wordList);

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


                        for(String str:findWord(newWord,set)){

                            if(set.contains(str)){

                                queue.add(str);
                                set.remove(str);
                            }


                        }



                }

            }

            level++;
        }
        
        return 0;
    }

    public List<String> findWord(String s,HashSet<String> set){

        List<String> list=new ArrayList<>();

    for(int i=0;i<s.length();i++){
        for(char ch='a';ch<='z';ch++){

            String word=s.substring(0,i)+ch+s.substring(i+1,s.length());

            if(set.contains(word)){
                list.add(word);
            }
        }
    }
        return list;
    }
}
