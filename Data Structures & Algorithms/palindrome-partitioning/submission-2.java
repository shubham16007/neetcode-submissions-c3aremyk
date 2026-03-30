class Solution {
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> partition(String s) {

        if(s.length()==0) return result;

        dfs(0,s,new ArrayList<>(),result);

        return result;
        
    }

    public void dfs(int start,String s,List<String> temp, List<List<String>> result){

        if(s.length()==start){
            result.add(new ArrayList<>(temp));
            return;
        }


        for(int end=start;end<s.length();end++){


            if(isPalindrom(s,start,end)){

                temp.add(s.substring(start,end+1));
                dfs(end+1,s,temp,result);
                temp.remove(temp.size()-1);
            }

        }

    }


    public boolean isPalindrom(String s,int l,int r){


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
