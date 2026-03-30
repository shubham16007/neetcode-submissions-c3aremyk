class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> result=new ArrayList<>();


        dfs(0,s,new ArrayList<>(),result);

        return result;
    }

    public void dfs(int start,String s,List<String> list,List<List<String>> result){


        if(s.length()==start){
            result.add(new ArrayList<>(list));
            return;
        }


        for(int end=start;end<s.length();end++){

            if(isPalindrome(start,end,s)){

                list.add(s.substring(start,end+1));
                dfs(end+1,s,list,result);
                list.remove(list.size()-1);
            }
        }
    }


    public boolean isPalindrome(int l,int r,String s){

        while(l<r){

            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
