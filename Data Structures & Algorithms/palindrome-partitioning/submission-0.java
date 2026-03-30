class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> result=new ArrayList<>();
        
        backtracking(0,s,new ArrayList<>(),result);

        return result;
        
    }

    public void backtracking(int start,String s,List<String> temp, List<List<String>> result){

        if(s.length()==start){

            result.add(new ArrayList<>(temp));
            return;
        }


        for(int end=start;end<s.length();end++){

            if(isPalindrome(start,s,end)){
            temp.add(s.substring(start,end+1));
            backtracking(end+1,s,temp,result);
            temp.remove(temp.size()-1);

            }

        }


    }


    public boolean isPalindrome(int l,String s,int r){


        while(l<r){

            if(s.charAt(l)!=s.charAt(r)) return false;

            l++;
            r--;
        }

        return true;
    }
}
